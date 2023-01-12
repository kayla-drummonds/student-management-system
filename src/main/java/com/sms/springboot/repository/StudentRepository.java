package com.sms.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.springboot.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByEmail(String email);

}
