package com.sms.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.springboot.model.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
	
}
