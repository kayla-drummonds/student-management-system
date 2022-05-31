package com.sms.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

	@GetMapping("/home")
	public String viewHomePage(Model model) {
		model.addAttribute("pageTitle", "Home");
		return "home";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	

}
