package com.sms.springboot.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sms.springboot.rest.ResourceConstants;
import com.sms.springboot.rest.model.StudentResponse;
import com.sms.springboot.rest.model.request.StudentRequest;

@RestController
@RequestMapping(ResourceConstants.STUDENTS_V1)
public class RestStudentController {

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> getStudents(@RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "name", required = false) String name) {
        return new ResponseEntity<>(new StudentResponse(), HttpStatus.OK);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> createStudent(@RequestBody StudentRequest studentRequest) {
        return new ResponseEntity<>(new StudentResponse(), HttpStatus.CREATED);
    }

    @PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> updateStudent(@RequestBody StudentRequest studentRequest) {
        return new ResponseEntity<>(new StudentResponse(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
