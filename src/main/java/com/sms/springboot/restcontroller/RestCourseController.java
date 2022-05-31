package com.sms.springboot.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.springboot.model.Course;
import com.sms.springboot.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class RestCourseController {

	@Autowired
	private CourseService courseService;

	public RestCourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}

	// handler method to handle list courses and return mode and view

	// build get a course by id REST API
	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("id") Long id) {
		Course course = courseService.getCourseById(id);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}
}
