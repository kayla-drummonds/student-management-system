package com.sms.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.springboot.model.Course;
import com.sms.springboot.service.impl.CourseServiceImpl;

@Controller
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	private CourseServiceImpl courseServiceImpl;

	public CourseController(CourseServiceImpl courseServiceImpl) {
		super();
		this.courseServiceImpl = courseServiceImpl;
	}

	@GetMapping("/all")
	public String listCourses(Model model) {
		model.addAttribute("courses", courseServiceImpl.getAllCourses());
		return "courses";
	}

	@GetMapping("/new")
	public String createNewCourse(Model model) {
		Course course = new Course();
		model.addAttribute("course", course);
		return "new_course";
	}
}
