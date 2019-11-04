package com.cdsi.clinica.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cdsi.clinica.app.common.PageInitPagDoctor;
import com.cdsi.clinica.app.model.Doctor;
import com.cdsi.clinica.app.model.Specialty;
import com.cdsi.clinica.app.service.IDoctorService;
import com.cdsi.clinica.app.service.ISpecialtyService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	protected static final String ARTICLE_VIEW = "doctor/showDoctor"; // view template for single Doctor
	protected static final String ARTICLE_ADD_FORM_VIEW = "doctor/newDoctor"; // form for new Doctor
	protected static final String ARTICLE_EDIT_FORM_VIEW = "doctor/editDoctor"; // form for editing an Doctor
	protected static final String ARTICLE_PAGE_VIEW = "doctor/allDoctor"; // list with pagination

	@Autowired
	private PageInitPagDoctor pagIntPagDoctor;
	
	@Autowired
	private IDoctorService doctorService;
	@Autowired
	private ISpecialtyService specialtService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{id}")
	public String getArticleById(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("doctor", doctorService.findById(id));
		return ARTICLE_VIEW;
	}

	@Secured({"ROLE_ADMIN"})
	@GetMapping
	public ModelAndView getAllArticles(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = pagIntPagDoctor.initPagination(pageSize, page, ARTICLE_PAGE_VIEW);
		return modelAndView;
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/new")
	public String newArticle(Model model) {
		List<Specialty> speList = specialtService.getAllServices();
		if (!model.containsAttribute("doctor")) {
			model.addAttribute("doctor", new Doctor() );
		}
		
		model.addAttribute("specialtList", speList);
		
		return ARTICLE_ADD_FORM_VIEW;
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/create")
	public String createArticle(@Valid Doctor doctor, BindingResult result, Model model, RedirectAttributes attr) {

		if (result.hasErrors() ) {
			// After the redirect: flash attributes pass attributes to the model
			attr.addFlashAttribute("org.springframework.validation.BindingResult.doctor", result);
			attr.addFlashAttribute("doctor", doctor);
			//attr.addFlashAttribute("error", "No se permite articulos con el mismo titulo y autor");
			return "redirect:/doctor/new";
		}
		Doctor newDoctor = doctorService.createDoctor(doctor);
		model.addAttribute("doctor", newDoctor);
		//return "redirect:/specialty/" + newSpecialty.getId();
		return "redirect:/doctor";
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("{id}/edit")
	public String editArticle(@PathVariable(value = "id") Long id, Model model) {
		List<Specialty> speList = specialtService.getAllServices();
		if (!model.containsAttribute("doctor")) {
			model.addAttribute("doctor", doctorService.findById(id));
		}
		model.addAttribute("specialtList", speList);
		return ARTICLE_EDIT_FORM_VIEW;
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping(path = "/{id}/update")
	public String updateArticle(@PathVariable(value = "id") Long id, @Valid Doctor doctor, BindingResult result, Model model, RedirectAttributes attr) {
		if (result.hasErrors()) {
			/// After the redirect: flash attributes pass attributes to the model
			attr.addFlashAttribute("org.springframework.validation.BindingResult.doctor", result);
			attr.addFlashAttribute("doctor", doctor);
			attr.addFlashAttribute("error", "No se permite Especialidades con el mismo codigo");
			return "redirect:/doctor/" + doctor.getId() + "/edit";
		}

		doctorService.updateDoctor(id, doctor);
		//model.addAttribute("doctor", doctorService.findById(id));
		//return "redirect:/specialty/" + id;
		return "redirect:/doctor";
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping(value = "/{id}/delete")
	public String deleteSpecialty(@PathVariable("id") Long id) {
		doctorService.deleteDoctor(id);
		return "redirect:/doctor";
	}
	
	
	
}
