package com.sms.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sms.springboot.model.Student;
import com.sms.springboot.service.StudentService;

@Controller
@RequestMapping
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	// handler method to handle list students and return model and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	@GetMapping("/registration")
	public String registration(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "registration";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Integer id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Integer id, @ModelAttribute("student") Student student, Model model) {

		// get student from database by id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(student.getId());
		existingStudent.setName(student.getName());
		existingStudent.setUsername(student.getUsername());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setPassword(student.getPassword());

		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}

	// handler method to handle delete student request

	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
}
