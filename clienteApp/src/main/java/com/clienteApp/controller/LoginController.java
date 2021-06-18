package com.clienteApp.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error, 
			@RequestParam(value="logout", required=false) String logout,
			Model model, Principal principal, RedirectAttributes atribute ) {
		if (error != null) {
			model.addAttribute("error", "ERRROR DE ACCESO: Usuario y/o contraseña son incorrectos");
		}
		if (principal != null) {
			atribute.addFlashAttribute("warning", "ATENCION: As iniciado sesión");
			return "redirect:/home";
		}
		if (logout != null) {
			model.addAttribute("success", "ATENCION: Ha finalizado sesión ");
		}
		return "login";
	}
}
