package com.sms.springboot.rest.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import com.sms.springboot.model.StudentCourse;
import com.sms.springboot.rest.model.StudentCourseResponse;

public class StudentCourseToStudentCourseResponse implements Converter<StudentCourse, StudentCourseResponse> {

    @Override
    @Nullable
    public StudentCourseResponse convert(StudentCourse source) {
        StudentCourseResponse scResponse = new StudentCourseResponse();
        scResponse.setStudent(source.getStudent().getId());
        scResponse.setCourse(source.getCourse().getId());
        scResponse.setProgress(source.getProgress());

        return scResponse;
    }

}
