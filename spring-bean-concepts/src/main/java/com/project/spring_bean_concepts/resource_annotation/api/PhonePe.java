package com.project.spring_bean_concepts.resource_annotation.api;

import org.springframework.stereotype.Service;

@Service("phonePe")
public class PhonePe implements Payment{
    @Override
    public String doTransaction() {
        return "phone pe transaction";
    }
}
