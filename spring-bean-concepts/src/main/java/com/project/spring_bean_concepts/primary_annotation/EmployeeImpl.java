package com.project.spring_bean_concepts.primary_annotation;

public class EmployeeImpl implements Employee {
    @Override
    public void work() {
        System.out.println("Employee is working.");
    }
}
