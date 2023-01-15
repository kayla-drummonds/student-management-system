package com.sms.springboot.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import com.sms.springboot.model.Student;
import com.sms.springboot.rest.converter.StudentToStudentResponseConverter;
import com.sms.springboot.rest.model.StudentResponse;

@Configuration
public class ConversionConfig {

    private Set<Converter<Student, StudentResponse>> getConverters() {
        Set<Converter<Student, StudentResponse>> converters = new HashSet<>();
        converters.add(new StudentToStudentResponseConverter());

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
