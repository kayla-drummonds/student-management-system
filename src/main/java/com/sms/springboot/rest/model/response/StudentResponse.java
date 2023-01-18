package com.sms.springboot.rest.model.response;

import java.util.List;

import com.sms.springboot.model.StudentCourse;
import com.sms.springboot.rest.model.Links;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

    private Integer id;

    private String username;

    private String name;

    private String email;

    private String password;

    private Links links;

    private List<StudentCourse> studentCourses;
}
