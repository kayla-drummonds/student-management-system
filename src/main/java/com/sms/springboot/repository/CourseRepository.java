package com.sms.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sms.springboot.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
	
	@Query("select c from Course c join fetch c.department where c.department = ?1")
	public Course findCourseByDepartmentId(Long id);

}
