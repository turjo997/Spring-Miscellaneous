package com.project.spring_bean_concepts;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SecondaryGreetingService implements GreetingService{
    @Override
    public void greet() {
        System.out.println("Hello from Secondary Greeting Service");
    }
}
