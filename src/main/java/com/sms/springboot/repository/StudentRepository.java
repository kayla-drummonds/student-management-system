package com.sms.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sms.springboot.model.Student;
import com.sms.springboot.model.StudentCourse;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByEmail(String email);
	
	@Query("select s from StudentCourse s where s.student = ?1")
	List<StudentCourse> findAllCoursesByStudentId();	
}
