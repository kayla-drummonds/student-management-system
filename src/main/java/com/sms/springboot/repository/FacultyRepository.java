package com.sms.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.springboot.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

}
