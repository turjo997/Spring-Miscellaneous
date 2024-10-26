package com.project.spring_bean_concepts.primary_annotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PermanentEmployee implements Employee{

    @Override
    public void work() {
        System.out.println("Permanent employees are working");
    }
}
