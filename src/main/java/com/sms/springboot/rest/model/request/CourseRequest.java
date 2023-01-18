package com.sms.springboot.rest.model.request;

import com.sms.springboot.model.Department;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private Integer id;
    private String name;
    private Department department;
}
