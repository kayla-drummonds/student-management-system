package com.sms.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.springboot.model.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {

	Course getCourseByDeptId(int deptId);
}
