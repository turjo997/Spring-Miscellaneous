package com.project.spring_bean_concepts;


import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
//@DependsOn("dependencyBean")
@DependsOn(value = {"dependencyBean" , "beanC"})
public class DependentBean {

    public DependentBean() {
        System.out.println("DependentBean is initialized after DependencyBean");
    }
}
