package com.project.spring_bean_concepts;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevBean {

    public DevBean() {
        System.out.println("DevBean for dev profile is initialized");
    }
}
