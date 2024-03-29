package com.sms.springboot.rest.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseResponse {
    private Integer id;
    private Integer student;
    private Integer course;
    private Double progress;
}
