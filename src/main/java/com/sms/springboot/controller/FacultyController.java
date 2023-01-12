package com.sms.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.springboot.service.FacultyService;

@Controller
@RequestMapping
public class FacultyController {
	
	private FacultyService facultyService;

	public FacultyController(FacultyService facultyService) {
		super();
		this.facultyService = facultyService;
	}
	
	@GetMapping("/faculty")
	public String listFaculty(Model model) {
		model.addAttribute("faculty", facultyService.getAllFaculty());
		return "faculty";
	}

}
