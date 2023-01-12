package com.sms.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.springboot.model.Faculty;
import com.sms.springboot.model.FacultyCourse;

public interface FacultyCourseRepository extends JpaRepository<FacultyCourse, Long> {

	@Query("Select f from FacultyCourse f join fetch f.faculty where f.faculty = ?1")
	List<FacultyCourse> findByFacultyId(Faculty faculty);

}
