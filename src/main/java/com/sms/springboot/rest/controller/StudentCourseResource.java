package com.sms.springboot.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sms.springboot.model.Course;
import com.sms.springboot.model.Student;
import com.sms.springboot.model.StudentCourse;
import com.sms.springboot.repository.CourseRepository;
import com.sms.springboot.repository.StudentCourseRepository;
import com.sms.springboot.repository.StudentRepository;
import com.sms.springboot.rest.ResourceConstants;
import com.sms.springboot.rest.model.StudentCourseResponse;
import com.sms.springboot.rest.model.request.StudentCourseRequest;

@RestController
@RequestMapping(ResourceConstants.STUDENTCOURSES_V1)
@CrossOrigin
public class StudentCourseResource {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentCourseRepository studentCourseRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ConversionService conversionService;

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentCourseResponse> getStudentCoursesList() {
        List<StudentCourse> scList = studentCourseRepository.findAll();
        ObjectMapper mapper = new ObjectMapper();

        List<StudentCourseResponse> scResponses = new ArrayList<>();

        for (StudentCourse sc : scList) {
            StudentCourseResponse response = mapper.convertValue(sc, StudentCourseResponse.class);
            scResponses.add(response);
        }

        return scResponses;
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentCourseResponse> createStudentCourse(
            @RequestBody StudentCourseRequest studentCourseRequest) {

        StudentCourse sc = conversionService.convert(studentCourseRequest, StudentCourse.class);
        Student student = studentRepository.findById(studentCourseRequest.getStudent()).get();
        Course course = courseRepository.findById(studentCourseRequest.getCourse()).get();

        if (sc != null) {
            sc.setStudent(student);
            sc.setCourse(course);
            studentCourseRepository.save(sc);

            student.addStudentCourse(sc);
            studentRepository.save(student);
        }

        StudentCourseResponse scResponse = conversionService.convert(sc, StudentCourseResponse.class);

        return new ResponseEntity<>(scResponse, HttpStatus.CREATED);
    }
}
