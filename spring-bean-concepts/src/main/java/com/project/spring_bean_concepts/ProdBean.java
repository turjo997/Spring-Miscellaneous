package com.project.spring_bean_concepts;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdBean {
    public ProdBean() {
        System.out.println("ProdBean for prod profile is initialized");
    }
}
