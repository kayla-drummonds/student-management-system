package com.sms.springboot.service;

import java.util.List;

import com.sms.springboot.model.Student;

public interface StudentService {
	Student findByEmail(String email);

	Student saveStudent(Student student);

	Student getStudentById(Integer id);

	List<Student> getAllStudents();

	Student updateStudent(Student student);

	void deleteStudentById(Integer id);
}
