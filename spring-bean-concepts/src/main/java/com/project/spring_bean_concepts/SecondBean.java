package com.project.spring_bean_concepts;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class SecondBean {

    public SecondBean() {
        System.out.println("SecondBean is initialized");
    }


}
