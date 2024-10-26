package com.project.spring_bean_concepts.primary_annotation;

import org.springframework.stereotype.Component;

@Component
public class ContractEmployee implements Employee{
    @Override
    public void work() {
        System.out.println("Contractual employees are working");
    }
}
