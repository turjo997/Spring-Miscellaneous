package com.project.spring_bean_concepts;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazyBean {

    public LazyBean(){
        System.out.println("LazyBean is initialized");
    }

    public void show() {
        System.out.println("LazyBean is running");
    }

}
