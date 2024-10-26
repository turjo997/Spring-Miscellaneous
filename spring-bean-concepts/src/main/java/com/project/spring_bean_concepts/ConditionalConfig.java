package com.project.spring_bean_concepts;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionalConfig {


    @Bean
    @Conditional(CustomCondition.class)
    public ConditionalBean conditionalBean(){
        return new ConditionalBean();
    }

}
