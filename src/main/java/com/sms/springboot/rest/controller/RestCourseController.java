package com.sms.springboot.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.springboot.rest.ResourceConstants;
import com.sms.springboot.rest.model.CourseResponse;

@RestController
@RequestMapping(ResourceConstants.COURSES_V1)
public class RestCourseController {

	@RequestMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseResponse> getAvailableCourses(@RequestParam(value = "id") Integer id) {
		return new ResponseEntity<>(new CourseResponse(), HttpStatus.OK);
	}
}
