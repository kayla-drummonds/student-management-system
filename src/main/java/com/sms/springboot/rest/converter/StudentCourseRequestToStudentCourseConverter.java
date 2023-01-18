package com.sms.springboot.rest.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import com.sms.springboot.model.StudentCourse;
import com.sms.springboot.rest.model.request.StudentCourseRequest;

public class StudentCourseRequestToStudentCourseConverter implements Converter<StudentCourseRequest, StudentCourse> {

    @Override
    @Nullable
    public StudentCourse convert(StudentCourseRequest source) {
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setProgress(source.getProgress());

        if (source.getId() != null) {
            studentCourse.setId(source.getId());
        }

        return studentCourse;
    }

}
