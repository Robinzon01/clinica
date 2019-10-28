package com.cdsi.clinica.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
<<<<<<< HEAD
import org.springframework.security.access.prepost.PreAuthorize;
=======

>>>>>>> dc86e82f23e87a81766a48d68c93047710a78115
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

<<<<<<< HEAD

@Controller
@RequestMapping({ "/", "/home" })

public class HomeController {
    /*
	@Autowired
	private ArticleService articleService;
    
	@Autowired
	private PageInitPagination pageInitPagination;
    */
	protected static final String INDEX_VIEW = "index"; // articles with pagination

	protected static final String ARTICLE_VIEW = "articles/showArticle"; // view template for single article
/*
=======
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

>>>>>>> dc86e82f23e87a81766a48d68c93047710a78115
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	@GetMapping
	public ModelAndView getIndex(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page) {
<<<<<<< HEAD
		ModelAndView modelAndView = pageInitPagination.initPagination(pageSize, page, INDEX_VIEW);
=======
		ModelAndView modelAndView = pegIntPagMediConsul.initPagination(pageSize, page, INDEX_VIEW);
>>>>>>> dc86e82f23e87a81766a48d68c93047710a78115
		return modelAndView;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{id}")
	public String getArticleById(@PathVariable(value = "id") Long articleId, Model model) {
<<<<<<< HEAD
		model.addAttribute("article", articleService.findById(articleId));
=======
		//model.addAttribute("article", medicalConsulService.findById(articleId));
>>>>>>> dc86e82f23e87a81766a48d68c93047710a78115
		return ARTICLE_VIEW;
	}
	
	
	@GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }
<<<<<<< HEAD
	*/
=======
>>>>>>> dc86e82f23e87a81766a48d68c93047710a78115

}
