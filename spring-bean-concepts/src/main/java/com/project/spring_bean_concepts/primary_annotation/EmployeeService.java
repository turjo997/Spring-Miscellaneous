package com.project.spring_bean_concepts.primary_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private Employee employee;


    public Employee getEmployee(){
        return employee;
    }
}
