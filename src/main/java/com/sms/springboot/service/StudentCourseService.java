package com.sms.springboot.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sms.springboot.model.Student;
import com.sms.springboot.model.StudentCourse;

@Component
public interface StudentCourseService {
	List<StudentCourse> getAllStudentCourses();

	StudentCourse saveStudentCourse(StudentCourse studentCourse);

	StudentCourse getStudentCourseById(Integer id);

	StudentCourse updateStudentCourse(StudentCourse studentCourse);

	// List<StudentCourse> getStudentCourseByStudent(Student student);
}
