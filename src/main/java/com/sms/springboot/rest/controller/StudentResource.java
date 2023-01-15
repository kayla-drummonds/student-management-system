package com.sms.springboot.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.springboot.model.Student;
import com.sms.springboot.repository.PageableStudentRepository;
import com.sms.springboot.repository.StudentRepository;
import com.sms.springboot.rest.ResourceConstants;
import com.sms.springboot.rest.model.Links;
import com.sms.springboot.rest.model.Self;
import com.sms.springboot.rest.model.StudentResponse;
import com.sms.springboot.rest.model.request.StudentRequest;

@RestController
@RequestMapping(ResourceConstants.STUDENTS_V1)
public class StudentResource {

    @Autowired
    PageableStudentRepository pageableStudentRepository;

    @Autowired
    StudentRepository studentRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentResponse> getStudentsList(
            @RequestParam(value = "id", required = false) Integer id) {

        List<Student> studentsList = studentRepository.findAll();

        ObjectMapper mapper = new ObjectMapper();

        List<StudentResponse> studentResponses = new ArrayList<>();

        for (Student s : studentsList) {
            Links links = new Links();
            Self self = new Self();
            self.setRef("/api" + ResourceConstants.STUDENTS_V1 + "/" + s.getId());
            links.setSelf(self);
            StudentResponse response = mapper.convertValue(s, StudentResponse.class);
            response.setLinks(links);
            studentResponses.add(response);
        }

        return studentResponses;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        Student student = studentRepository.findById(id).get();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest studentRequest) {
        return new ResponseEntity<>(new StudentResponse(), HttpStatus.CREATED);
    }

    @PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> updateStudent(@RequestBody StudentRequest studentRequest) {
        return new ResponseEntity<>(new StudentResponse(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
