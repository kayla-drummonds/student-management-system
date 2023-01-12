package com.sms.springboot.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.sms.springboot.model.Course;
import com.sms.springboot.repository.CourseRepository;
import com.sms.springboot.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseRepository courseRepository;

	public CourseServiceImpl(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	@Override
	public Course getCourseById(Long id) {
		return courseRepository.getById(id);
	}

	public Course save(Course newCourse) {
		return courseRepository.save(newCourse);
	}

	@Override
	public Course getCourseByDepartmentId(Long id) {
		return courseRepository.findCourseByDepartmentId(id);
	}
}
