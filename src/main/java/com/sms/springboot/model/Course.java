package com.sms.springboot.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")

public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5950518833082521767L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	@Column
	private int deptId;

	public Course() {

	}

	public Course(String name, int deptId) {
		this.name = name;
		this.deptId = deptId;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", deptId=" + deptId + "]";
	}

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

}
