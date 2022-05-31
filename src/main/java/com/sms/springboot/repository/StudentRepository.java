package com.sms.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.springboot.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	Student findByEmail(String email);
	
}
