package com.project.spring_bean_concepts.resource_annotation.api;

import org.springframework.stereotype.Service;

@Service("paytm")
public class Paytm implements Payment{
    @Override
    public String doTransaction() {
        return "paytm transaction";
    }
}
