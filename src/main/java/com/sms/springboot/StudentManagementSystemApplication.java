package com.sms.springboot;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.sms.springboot.model.Student;
import com.sms.springboot.repository.StudentRepository;

@SpringBootApplication
@ComponentScan
public class StudentManagementSystemApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Iterable<Student> itr = studentRepository.findAll();
		System.out.println("Printing data: ");
		for (Student s : itr) {
			System.out.println(s.getId() + ": " + s.getName());
		}
	}

}
