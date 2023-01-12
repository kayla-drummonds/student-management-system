package com.sms.springboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sms.springboot.model.Faculty;
import com.sms.springboot.model.FacultyCourse;
import com.sms.springboot.repository.FacultyCourseRepository;
import com.sms.springboot.service.FacultyCourseService;

@Service
public class FacultyCourseServiceImpl implements FacultyCourseService {

	private FacultyCourseRepository facultyCourseRepository;
	
	public FacultyCourseServiceImpl(FacultyCourseRepository facultyCourseRepository) {
		super();
		this.facultyCourseRepository = facultyCourseRepository;
	}

	@Override
	public List<FacultyCourse> getFacultyCourseByFacultyId(Faculty faculty) {
		return facultyCourseRepository.findByFacultyId(faculty);
	}

}
