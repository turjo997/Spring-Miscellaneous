package com.project.spring_bean_concepts;

import org.springframework.stereotype.Component;

@Component
public class DependencyBean {

    public DependencyBean() {
        System.out.println("DependencyBean is initialized");
    }

}
