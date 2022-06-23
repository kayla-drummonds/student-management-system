package com.sms.springboot.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sms.springboot.model.Department;

@Component
public interface DepartmentService {
	List<Department> getAllDepartments();
	Department getDepartmentById(Long id);

}
