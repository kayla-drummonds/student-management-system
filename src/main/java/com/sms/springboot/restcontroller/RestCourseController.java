package com.sms.springboot.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.springboot.model.Course;
import com.sms.springboot.service.impl.CourseServiceImpl;

@RestController
@RequestMapping("/courses")
public class RestCourseController {

	@Autowired
	private CourseServiceImpl courseService;

	public RestCourseController(CourseServiceImpl courseService) {
		super();
		this.courseService = courseService;
	}

	// handler method to handle list courses and return mode and view

	// build get a course by id REST API
	@GetMapping("/{id}")
	public Course getCourseById(@PathVariable("id") Integer id) {
		Course course = courseService.getCourseById(id);
		return course;
	}
}
