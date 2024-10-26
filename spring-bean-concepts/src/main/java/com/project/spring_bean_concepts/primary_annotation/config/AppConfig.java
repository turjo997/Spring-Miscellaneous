package com.project.spring_bean_concepts.primary_annotation.config;

import com.project.spring_bean_concepts.primary_annotation.Employee;
import com.project.spring_bean_concepts.primary_annotation.EmployeeImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public Employee employee(){
        return new EmployeeImpl();
    }

}
