package com.sms.springboot.service;

import java.util.List;

import com.sms.springboot.model.Faculty;

public interface FacultyService {
	List<Faculty> getAllFaculty();

	Faculty getFacultyById(Integer id);
}
