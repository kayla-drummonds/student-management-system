package com.sms.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sms.springboot.model.Department;
import com.sms.springboot.repository.DepartmentRepository;
import com.sms.springboot.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;
	
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(Long id) {
		return departmentRepository.getById(id);
	}

}
