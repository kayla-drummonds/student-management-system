package com.sms.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.springboot.service.impl.CourseServiceImpl;
import com.sms.springboot.service.impl.DepartmentServiceImpl;

@Controller
@RequestMapping
public class DepartmentController {

	@Autowired
	private DepartmentServiceImpl departmentService;

	@Autowired
	private CourseServiceImpl courseService;

	public DepartmentController(DepartmentServiceImpl departmentService) {
		super();
		this.departmentService = departmentService;
	}

	@GetMapping("/departments")
	public String listDepartments(Model model) {
		model.addAttribute("departments", departmentService.getAllDepartments());
		return "departments";
	}

	@GetMapping("/departments/{id}")
	public String listCoursesByDepartment(@PathVariable Integer id, Model model) {
		model.addAttribute("department_courses", courseService.getCourseByDepartmentId(id));
		return "department_courses";
	}
}
