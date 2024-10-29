package com.project.spring_bean_concepts.resource_annotation.config;

import com.project.spring_bean_concepts.resource_annotation.api.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentConfig {

    @Value("${beanName}")
    private String beanName;

    private final ApplicationContext context;

    public PaymentConfig(ApplicationContext context) {
        this.context = context;
    }

    @Bean(name = "paymentBean")
    public Payment payment() {
        return (Payment) context.getBean(beanName);
    }
}
