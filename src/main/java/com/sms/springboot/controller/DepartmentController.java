package com.sms.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.springboot.service.impl.DepartmentServiceImpl;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;

	public DepartmentController(DepartmentServiceImpl departmentServiceImpl) {
		super();
		this.departmentServiceImpl = departmentServiceImpl;
	}
	
	@GetMapping("/all")
	public String listDepartments(Model model) {
		model.addAttribute("departments", departmentServiceImpl.getAllDepartments());
		return "departments";
	}
}
