package com.cdsi.clinica.app.controller;


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

import com.cdsi.clinica.app.common.PageInitPagPatient;
import com.cdsi.clinica.app.model.Doctor;
import com.cdsi.clinica.app.model.Patient;
import com.cdsi.clinica.app.service.IPatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	protected static final String ARTICLE_VIEW = "paciente/showPatient"; // view template for single Doctor
	protected static final String ARTICLE_ADD_FORM_VIEW = "paciente/newPatient"; // form for new Doctor
	protected static final String ARTICLE_EDIT_FORM_VIEW = "paciente/editPatient"; // form for editing an Doctor
	protected static final String ARTICLE_PAGE_VIEW = "paciente/allPatient"; // list with pagination

	@Autowired
	private PageInitPagPatient initPagPatient;
	
	@Autowired
	private IPatientService patientService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{id}")
	public String getArticleById(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("patient", patientService.findById(id));
		return ARTICLE_VIEW;
	}

	@Secured({"ROLE_ADMIN"})
	@GetMapping
	public ModelAndView getAllArticles(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = initPagPatient.initPagination(pageSize, page, ARTICLE_PAGE_VIEW);
		return modelAndView;
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/new")
	public String newArticle(Model model) {
		
		if (!model.containsAttribute("patient")) {
			model.addAttribute("patient", new Patient() );
		}		
		return ARTICLE_ADD_FORM_VIEW;
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/create")
	public String createArticle(@Valid Patient patient, BindingResult result, Model model, RedirectAttributes attr) {

		if (result.hasErrors() ) {
			// After the redirect: flash attributes pass attributes to the model
			attr.addFlashAttribute("org.springframework.validation.BindingResult.patient", result);
			attr.addFlashAttribute("patient", patient);
			//attr.addFlashAttribute("error", "No se permite articulos con el mismo titulo y autor");
			return "redirect:/patient/new";
		}
		Patient newPatient = patientService.createPatient(patient);
		model.addAttribute("patient", newPatient);
		//return "redirect:/specialty/" + newSpecialty.getId();
		return "redirect:/patient";
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("{id}/edit")
	public String editArticle(@PathVariable(value = "id") Long id, Model model) {
	
		if (!model.containsAttribute("doctor")) {
			model.addAttribute("patient", patientService.findById(id));
		}

		return ARTICLE_EDIT_FORM_VIEW;
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping(path = "/{id}/update")
	public String updateArticle(@PathVariable(value = "id") Long id, @Valid Patient patient, BindingResult result, Model model, RedirectAttributes attr) {
		if (result.hasErrors()) {
			/// After the redirect: flash attributes pass attributes to the model
			attr.addFlashAttribute("org.springframework.validation.BindingResult.doctor", result);
			attr.addFlashAttribute("patient", patient);
			attr.addFlashAttribute("error", "No se permite Especialidades con el mismo codigo");
			return "redirect:/patient/" + patient.getId() + "/edit";
		}

		patientService.updatePatient(id, patient);
		//model.addAttribute("doctor", doctorService.findById(id));
		//return "redirect:/specialty/" + id;
		return "redirect:/patient";
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping(value = "/{id}/delete")
	public String deleteSpecialty(@PathVariable("id") Long id) {
		patientService.deletePatient(id);
		return "redirect:/patient";
	}
		
}
