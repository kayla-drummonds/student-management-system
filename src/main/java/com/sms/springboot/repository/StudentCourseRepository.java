package com.sms.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.springboot.model.StudentCourse;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {

}
