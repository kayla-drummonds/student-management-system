package com.sms.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studentcourse")
public class StudentCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private int sId;

	@Column
	private int courseId;

	@Column(name = "progress", nullable = false)
	private double progress;

	public StudentCourse() {

	}

	public StudentCourse(int sId, int courseId, double progress) {
		super();
		this.sId = sId;
		this.courseId = courseId;
		this.progress = progress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSId() {
		return sId;
	}

	public void setSId(int sId) {
		this.sId = sId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public double getProgress() {
		return progress;
	}

	public void setProgress(double progress) {
		this.progress = progress;
	}

	@Override
	public String toString() {
		return "StudentCourse [id=" + id + ", studentId=" + sId + ", courseId=" + courseId + ", progress="
				+ progress + "]";
	}
		
}
