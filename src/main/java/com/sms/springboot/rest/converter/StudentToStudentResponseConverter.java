package com.sms.springboot.rest.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import com.sms.springboot.model.Student;
import com.sms.springboot.rest.ResourceConstants;
import com.sms.springboot.rest.model.Links;
import com.sms.springboot.rest.model.Self;
import com.sms.springboot.rest.model.StudentResponse;

public class StudentToStudentResponseConverter implements Converter<Student, StudentResponse> {

    @Override
    @Nullable
    public StudentResponse convert(Student source) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(source.getId());
        studentResponse.setName(source.getName());
        studentResponse.setUsername(source.getUsername());
        studentResponse.setEmail(source.getEmail());
        studentResponse.setPassword(source.getPassword());

        Links links = new Links();
        Self self = new Self();
        self.setRef(ResourceConstants.STUDENTS_V1 + "/" + source.getId());
        links.setSelf(self);

        studentResponse.setLinks(links);

        return studentResponse;
    }

}
