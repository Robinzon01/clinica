package com.cdsi.clinica.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cdsi.clinica.app.common.PageInitPagMediConsult;

@Controller
@RequestMapping({ "/", "/home" })

public class HomeController {

	//private ArticleService articleService;

	@Autowired
	private PageInitPagMediConsult pegIntPagMediConsul;

	protected static final String INDEX_VIEW = "index"; // articles with pagination
	//MANTENIMIENTOS
	protected static final String SPECIALTY_ALL = "especialidad/allSpecialty";
	protected static final String DOCTOR_ALL = "doctor/allDoctor";
	protected static final String PATIENT_ALL = "patient/allPatient";
	//CONSULTA MEDICA
	protected static final String MEDCON_NEW = "medCon/newMedCon";
	protected static final String MEDCON_ALL = "medCon/showMedCon";

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = { "/specialty/all" })
	public ModelAndView getIndex(@RequestParam("pageSize") Optional<Integer> pageSize,@RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = pegIntPagMediConsul.initPagination(pageSize, page, SPECIALTY_ALL);
		return modelAndView;
	}
    /*
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{id}")
	public String getArticleById(@PathVariable(value = "id") Long articleId, Model model) {
		//model.addAttribute("article", medicalConsulService.findById(articleId));
		return ARTICLE_VIEW;
	}
    */

	@GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

}
