package com.sms.springboot.rest.model.request;

import java.util.List;

import com.sms.springboot.model.StudentCourse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String id;

    private String username;

    private String name;

    private String email;

    private String password;

    private List<StudentCourse> studentCourses;
}
