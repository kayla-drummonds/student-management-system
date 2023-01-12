package com.sms.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.springboot.model.Student;
import com.sms.springboot.model.StudentCourse;
import com.sms.springboot.service.impl.StudentCourseServiceImpl;

@RestController
@RequestMapping("/studentcourses")
public class RestStudentCourseController {

	@Autowired
	private StudentCourseServiceImpl studentCourseService;

	public RestStudentCourseController(StudentCourseServiceImpl studentCourseService) {
		super();
		this.studentCourseService = studentCourseService;
	}
	
	@GetMapping("/{student}")
	public List<StudentCourse> getStudentCourseByStudentId(@PathVariable("student") Student student) {
		List<StudentCourse> studentCourse = studentCourseService.getStudentCourseByStudent(student);
		return studentCourse;
	}
	
	

}
