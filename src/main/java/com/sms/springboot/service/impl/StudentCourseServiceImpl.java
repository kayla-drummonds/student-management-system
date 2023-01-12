package com.sms.springboot.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.sms.springboot.model.Student;
import com.sms.springboot.model.StudentCourse;
import com.sms.springboot.repository.StudentCourseRepository;
import com.sms.springboot.service.StudentCourseService;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

	private StudentCourseRepository studentCourseRepository;

	public StudentCourseServiceImpl(StudentCourseRepository studentCourseRepository) {
		super();
		this.studentCourseRepository = studentCourseRepository;
	}

	@Override
	public List<StudentCourse> getAllStudentCourses() {
		return studentCourseRepository.findAll();
	}

	@Override
	public StudentCourse saveStudentCourse(StudentCourse studentCourse) {
		return studentCourseRepository.save(studentCourse);
	}

	@Override
	public StudentCourse getStudentCourseById(Integer id) {
		return studentCourseRepository.findById(id).get();
	}

	@Override
	public StudentCourse updateStudentCourse(StudentCourse studentCourse) {
		return studentCourseRepository.save(studentCourse);
	}

	@Override
	public List<StudentCourse> getStudentCourseByStudent(Student student) {
		return studentCourseRepository.findByStudent(student);
	}
}
