package com.sms.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "facultycourses")
public class FacultyCourse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="faculty_id")
	public Faculty faculty;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	public Course course;

	public FacultyCourse() {
	}

	public FacultyCourse(Long id, Faculty faculty, Course course) {
		this.id = id;
		this.faculty = faculty;
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "FacultyCourse [id=" + id + ", faculty=" + faculty + ", course=" + course + "]";
	}
	
	
}
