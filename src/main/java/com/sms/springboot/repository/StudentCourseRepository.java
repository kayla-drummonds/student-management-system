package com.sms.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sms.springboot.model.Student;
import com.sms.springboot.model.StudentCourse;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
	
	@Query("select s from StudentCourse s join fetch s.student where s.student = ?1")
	public List<StudentCourse> findByStudent(Student student);

}
