package com.sms.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sms.springboot.model.Student;

public interface PageableStudentRepository extends PagingAndSortingRepository<Student, Integer> {
    Page<Student> findById(Integer id, Pageable page);
}
