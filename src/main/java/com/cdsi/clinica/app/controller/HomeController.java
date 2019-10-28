package com.cdsi.clinica.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cdsi.clinica.app.common.PageInitPagMediConsult;
import com.cdsi.clinica.app.service.IMedicalConsultationService;

import org.springframework.security.access.prepost.PreAuthorize;


@Controller
@RequestMapping({ "/", "/home" })
public class HomeController {

	@Autowired
	private IMedicalConsultationService medicalConsulService;
	//private ArticleService articleService;

	@Autowired
	private PageInitPagMediConsult pegIntPagMediConsul;

	protected static final String INDEX_VIEW = "index"; // articles with pagination

	protected static final String ARTICLE_VIEW = "consultMedica/showConsultMedi"; // view template for single article

	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	@GetMapping
	public ModelAndView getIndex(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
		ModelAndView modelAndView = pegIntPagMediConsul.initPagination(pageSize, page, INDEX_VIEW);
		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{id}")
	public String getArticleById(@PathVariable(value = "id") Long articleId, Model model) {
		//model.addAttribute("article", medicalConsulService.findById(articleId));
		return ARTICLE_VIEW;
	}
	
	
	@GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }

}
