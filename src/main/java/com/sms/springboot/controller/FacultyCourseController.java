package com.sms.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.springboot.model.Faculty;
import com.sms.springboot.service.impl.FacultyCourseServiceImpl;

@Controller
@RequestMapping
public class FacultyCourseController {

	private FacultyCourseServiceImpl facultyCourseService;

	public FacultyCourseController(FacultyCourseServiceImpl facultyCourseService) {
		super();
		this.facultyCourseService = facultyCourseService;
	}
	
	@GetMapping("/facultycourses/{faculty}")
	public String listFacultyCourseByFacultyId(@PathVariable("faculty") Faculty faculty, Model model) {
		model.addAttribute("faculty_courses", facultyCourseService.getFacultyCourseByFacultyId(faculty));
		return "faculty_courses";
	}
}
