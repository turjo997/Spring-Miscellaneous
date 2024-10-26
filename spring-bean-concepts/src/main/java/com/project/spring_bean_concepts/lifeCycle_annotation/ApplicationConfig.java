package com.project.spring_bean_concepts.lifeCycle_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {


    @Bean
    public MessageService messageService(){
        return new MessageService();
    }
}
