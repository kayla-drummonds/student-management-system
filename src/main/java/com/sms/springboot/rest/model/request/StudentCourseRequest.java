package com.sms.springboot.rest.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseRequest {
    private Integer id;
    private Integer student;
    private Integer course;
    private Double progress;
}
