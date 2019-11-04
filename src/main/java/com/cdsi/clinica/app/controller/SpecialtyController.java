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

import com.cdsi.clinica.app.common.PageInitPagSpecialty;
import com.cdsi.clinica.app.model.Specialty;
import com.cdsi.clinica.app.service.ISpecialtyService;

@Controller
@RequestMapping("/specialty")
public class SpecialtyController {

	protected static final String ARTICLE_VIEW = "especialidad/showSpecialty"; // view template for single Specialty
	protected static final String ARTICLE_ADD_FORM_VIEW = "especialidad/newSpecialty"; // form for new Specialty
	protected static final String ARTICLE_EDIT_FORM_VIEW = "especialidad/editSpecialty"; // form for editing an Specialty
	protected static final String ARTICLE_PAGE_VIEW = "especialidad/allSpecialty"; // list with pagination

	protected static final String INDEX_VIEW = "index"; // Specialty with pagination

	@Autowired
	private PageInitPagSpecialty pagIntPagSpec;
	
	@Autowired
	private ISpecialtyService specialService;

	@PreAuthorize("hasRole('ROLE_DOCTOR') or hasRole('ROLE_ADMIN')")
	@GetMapping("/{id}")
	public String getArticleById(@PathVariable(value = "id") Long articleId, Model model) {
		model.addAttribute("specialty", specialService.findById(articleId));
		return ARTICLE_VIEW;
	}

	@Secured({"ROLE_ADMIN"})
	@GetMapping
	public ModelAndView getAllArticles(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = pagIntPagSpec.initPagination(pageSize, page, ARTICLE_PAGE_VIEW);
		return modelAndView;
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/new")
	public String newArticle(Model model) {

		// in case of redirection model will contain article
		if (!model.containsAttribute("specialty")) {
			model.addAttribute("specialty", new Specialty() );
		}
		return ARTICLE_ADD_FORM_VIEW;
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/create")
	public String createArticle(@Valid Specialty specialty, BindingResult result, Model model, RedirectAttributes attr) {

		if (result.hasErrors() ) {

			// After the redirect: flash attributes pass attributes to the model
			attr.addFlashAttribute("org.springframework.validation.BindingResult.article", result);
			attr.addFlashAttribute("specialty", specialty);

			//attr.addFlashAttribute("error", "No se permite articulos con el mismo titulo y autor");

			return "redirect:/specialty/new";
		}
		Specialty newSpecialty = specialService.createSpecialty(specialty);
		model.addAttribute("specialty", newSpecialty);

		//return "redirect:/specialty/" + newSpecialty.getId();
		  return "redirect:/specialty";
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("{id}/edit")
	public String editArticle(@PathVariable(value = "id") Long id, Model model) {

		if (!model.containsAttribute("specialty")) {
			model.addAttribute("specialty", specialService.findById(id));
		}
		return ARTICLE_EDIT_FORM_VIEW;
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping(path = "/{id}/update")
	public String updateArticle(@PathVariable(value = "id") Long id, @Valid Specialty specialty,
			BindingResult result, Model model, RedirectAttributes attr) {
		if (result.hasErrors()) {
			/// After the redirect: flash attributes pass attributes to the model
			attr.addFlashAttribute("org.springframework.validation.BindingResult.article", result);
			attr.addFlashAttribute("specialty", specialty);

			attr.addFlashAttribute("error", "No se permite Especialidades con el mismo codigo");

			return "redirect:/specialty/" + specialty.getId() + "/edit";
		}

		specialService.updateSpecialty(id, specialty);
		model.addAttribute("specialty", specialService.findById(id));
		//return "redirect:/specialty/" + id;
		return "redirect:/specialty";
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping(value = "/{id}/delete")
	public String deleteSpecialty(@PathVariable("id") Long id) {
		specialService.deleteSpecialty(id);
		return "redirect:/specialty";
	}
	
	
	
}
