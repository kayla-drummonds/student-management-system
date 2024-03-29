package com.sms.springboot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String username;

	@Column
	private String name;

	@Column
	private String email;

	@Column
	private String password;

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private List<StudentCourse> studentCourses;

	public void addStudentCourse(StudentCourse studentCourse) {
		if (studentCourses == null) {
			studentCourses = new ArrayList<>();
			studentCourses.add(studentCourse);
		}
	}

}
