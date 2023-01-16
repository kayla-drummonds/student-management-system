package com.sms.springboot.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.springboot.model.Course;
import com.sms.springboot.model.Student;
import com.sms.springboot.model.StudentCourse;
import com.sms.springboot.repository.CourseRepository;
import com.sms.springboot.repository.PageableStudentRepository;
import com.sms.springboot.repository.StudentCourseRepository;
import com.sms.springboot.repository.StudentRepository;
import com.sms.springboot.rest.ResourceConstants;
import com.sms.springboot.rest.model.Links;
import com.sms.springboot.rest.model.Self;
import com.sms.springboot.rest.model.StudentCourseResponse;
import com.sms.springboot.rest.model.StudentResponse;
import com.sms.springboot.rest.model.request.StudentCourseRequest;
import com.sms.springboot.rest.model.request.StudentRequest;

@RestController
@RequestMapping(ResourceConstants.STUDENTS_V1)
@CrossOrigin
public class StudentResource {

    @Autowired
    PageableStudentRepository pageableStudentRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentCourseRepository studentCourseRepository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentResponse> getStudentsList(
            @RequestParam(value = "course", required = false) Integer course,
            @RequestParam(value = "progress", required = false) Double progress) {

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
        ObjectMapper mapper = new ObjectMapper();
        Student s = mapper.convertValue(studentRequest, Student.class);
        List<StudentCourse> sc = new ArrayList<>();
        s.setStudentCourses(sc);
        studentRepository.save(s);
        return new ResponseEntity<>(new StudentResponse(), HttpStatus.CREATED);
    }

    @PostMapping(path = "/addcourse", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentCourseResponse> createStudentCourse(
            @RequestBody StudentCourseRequest studentCourseRequest) {

        ObjectMapper mapper = new ObjectMapper();
        StudentCourse sc = mapper.convertValue(studentCourseRequest, StudentCourse.class);
        Student s = studentRepository.findById(studentCourseRequest.getStudent()).get();
        Course c = courseRepository.findById(studentCourseRequest.getCourse()).get();
        sc.setId(studentCourseRequest.getId());
        sc.setStudent(s);
        sc.setCourse(c);
        sc.setProgress(studentCourseRequest.getProgress());
        studentCourseRepository.save(sc);

        Student student = studentRepository.findById(studentCourseRequest.getStudent()).get();
        student.addStudentCourse(sc);
        studentRepository.save(student);
        sc.setStudent(student);
        studentCourseRepository.save(sc);

        System.out.println(sc.toString());

        return new ResponseEntity<>(new StudentCourseResponse(), HttpStatus.CREATED);
    }

    @PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponse> updateStudent(@RequestBody StudentRequest studentRequest) {
        return new ResponseEntity<>(new StudentResponse(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
