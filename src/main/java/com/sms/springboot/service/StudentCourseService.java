package com.sms.springboot.service;

import java.util.List;
import com.sms.springboot.model.StudentCourse;

public interface StudentCourseService {
	List<StudentCourse> getAllStudentCourses();
	StudentCourse saveStudentCourse(StudentCourse studentCourse);
}
