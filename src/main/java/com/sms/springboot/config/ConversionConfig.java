package com.sms.springboot.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import com.sms.springboot.rest.converter.CourseToCourseResponseConverter;
import com.sms.springboot.rest.converter.StudentCourseRequestToStudentCourseConverter;
import com.sms.springboot.rest.converter.StudentCourseToStudentCourseResponse;
import com.sms.springboot.rest.converter.StudentToStudentResponseConverter;

@Configuration
public class ConversionConfig {

    private Set<Converter> getConverters() {
        Set<Converter> converters = new HashSet<>();
        converters.add(new StudentToStudentResponseConverter());
        converters.add(new StudentCourseRequestToStudentCourseConverter());
        converters.add(new StudentCourseToStudentCourseResponse());
        converters.add(new CourseToCourseResponseConverter());
        return converters;
    }

    @Bean
    public ConversionService conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(getConverters());
        bean.afterPropertiesSet();
        return bean.getObject();
    }
}
