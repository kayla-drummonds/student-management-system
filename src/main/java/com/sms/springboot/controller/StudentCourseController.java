package com.sms.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.springboot.model.StudentCourse;
import com.sms.springboot.service.StudentCourseService;

@Controller
@RequestMapping("/studentcourses")
public class StudentCourseController {
	
	private StudentCourseService studentCourseService;

	public StudentCourseController(StudentCourseService studentCourseService) {
		super();
		this.studentCourseService = studentCourseService;
	}

	// build a new student course API
	@GetMapping("/new")
	public String createStudentCourseForm(Model model) {
		StudentCourse studentCourse = new StudentCourse();
		model.addAttribute("studentcourse", studentCourse);
		return "create_studentcourse";
	}

	@PostMapping("/all")
	public String saveStudentCourse(@ModelAttribute("studentcourse") StudentCourse studentCourse) {
		studentCourseService.saveStudentCourse(studentCourse);
		return "redirect:/studentcourses";
	}
	
	//handler method to handle list student's courses and return model and view
	@GetMapping("/all")
	public String listStudentCourses(Model model) {
		model.addAttribute("studentcourses", studentCourseService.getAllStudentCourses());
		return "student_courses";
	}
}
