package com.sms.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "studentcourses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "student_id")
	 * public Student student;
	 */

	@Column(name = "student_id")
	public Integer student;

	@ManyToOne
	@JoinColumn(name = "course_id")
	public Course course;

	@Column(name = "progress")
	private Double progress;

}
