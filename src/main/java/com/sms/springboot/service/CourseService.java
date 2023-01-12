package com.sms.springboot.service;

import java.util.List;
import com.sms.springboot.model.Course;
import org.springframework.stereotype.Component;

@Component
public interface CourseService {
	List<Course> getAllCourses();
	Course getCourseById(Long id);
	Course getCourseByDepartmentId(Long id);
}
