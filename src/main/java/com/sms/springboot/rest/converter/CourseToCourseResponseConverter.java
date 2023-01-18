package com.sms.springboot.rest.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import com.sms.springboot.model.Course;
import com.sms.springboot.rest.ResourceConstants;
import com.sms.springboot.rest.model.Links;
import com.sms.springboot.rest.model.Self;
import com.sms.springboot.rest.model.response.CourseResponse;

public class CourseToCourseResponseConverter implements Converter<Course, CourseResponse> {

    @Override
    @Nullable
    public CourseResponse convert(Course source) {
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setId(source.getId());
        courseResponse.setName(source.getName());
        courseResponse.setDepartment(source.getDepartment());

        Links links = new Links();
        Self self = new Self();
        self.setRef(ResourceConstants.COURSES_V1 + "/" + source.getId());
        links.setSelf(self);
        courseResponse.setLinks(links);

        return courseResponse;
    }

}
