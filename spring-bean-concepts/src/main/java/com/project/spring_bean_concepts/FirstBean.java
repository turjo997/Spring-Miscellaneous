package com.project.spring_bean_concepts;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class FirstBean {

    public FirstBean() {
        System.out.println("FirstBean is initialized");
    }

}
