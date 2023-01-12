package com.sms.springboot.service;

import java.util.List;

import com.sms.springboot.model.Student;
import com.sms.springboot.model.StudentCourse;

public interface StudentService {
		Student findByEmail(String email);
		Student saveStudent(Student student);
		Student getStudentById(Long id);
		List<Student> getAllStudents();
		Student updateStudent(Student student);
		void deleteStudentById(Long id);
		List<StudentCourse> getAllStudentCourses();
}
