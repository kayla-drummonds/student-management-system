package com.sms.springboot.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sms.springboot.model.Faculty;
import com.sms.springboot.model.FacultyCourse;

@Component
public interface FacultyCourseService {
	List<FacultyCourse> getFacultyCourseByFacultyId(Faculty faculty);
}
