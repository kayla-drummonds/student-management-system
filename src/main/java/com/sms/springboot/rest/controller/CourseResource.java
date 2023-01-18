package com.sms.springboot.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.springboot.model.Course;
import com.sms.springboot.repository.CourseRepository;
import com.sms.springboot.rest.ResourceConstants;
import com.sms.springboot.rest.model.response.CourseResponse;

@RestController
@RequestMapping(ResourceConstants.COURSES_V1)
@CrossOrigin
public class CourseResource {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	ConversionService conversionService;

	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CourseResponse> getAvailableCourses() {
		List<Course> cList = courseRepository.findAll();
		List<CourseResponse> courseResponses = new ArrayList<>();

		for (Course c : cList) {
			CourseResponse response = conversionService.convert(c, CourseResponse.class);
			courseResponses.add(response);
		}
		return courseResponses;
	}
}
