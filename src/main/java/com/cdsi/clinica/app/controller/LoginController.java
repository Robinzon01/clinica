package com.cdsi.clinica.app.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class LoginController {

	@GetMapping(value = { "/login" })
	public String login(@RequestParam(value = "error", required = false) String error,
<<<<<<< HEAD
			@RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
=======
			@RequestParam(value = "logout", required = false) String logout,
			Model model, Principal principal,
>>>>>>> dc86e82f23e87a81766a48d68c93047710a78115
			RedirectAttributes flash) {

		if (principal != null) {
			return "redirect:/articles/allArticles";
		}

		if (error != null) {
			model.addAttribute("error",
					"Error en el login: Nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!");
		}

		if (logout != null) {
			model.addAttribute("success", "Ha cerrado sesión con éxito!");
		}

		return "login";
	}
<<<<<<< HEAD
=======
	
>>>>>>> dc86e82f23e87a81766a48d68c93047710a78115
}