package com.sms.springboot.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.springboot.model.Course;
import com.sms.springboot.repository.CourseRepository;

@RestController
@RequestMapping("/courses")
public class RestCourseController {

	@Autowired
	private CourseRepository courseRepository;

	@RequestMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> getAvailableCourses() {
		return new ResponseEntity<>(new Course(), HttpStatus.OK);
	}
}
