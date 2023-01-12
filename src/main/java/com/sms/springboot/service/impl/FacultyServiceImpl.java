package com.sms.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.springboot.model.Faculty;
import com.sms.springboot.repository.FacultyRepository;
import com.sms.springboot.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	private FacultyRepository facultyRepository;
	
	
	public FacultyServiceImpl(FacultyRepository facultyRepository) {
		super();
		this.facultyRepository = facultyRepository;
	}

	@Override
	public List<Faculty> getAllFaculty() {
		return facultyRepository.findAll();
	}

	@Override
	public Faculty getFacultyById(Long id) {
		return facultyRepository.findById(id).get();
	}

}
