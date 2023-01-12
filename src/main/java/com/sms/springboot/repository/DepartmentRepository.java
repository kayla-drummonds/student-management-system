package com.sms.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.springboot.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
