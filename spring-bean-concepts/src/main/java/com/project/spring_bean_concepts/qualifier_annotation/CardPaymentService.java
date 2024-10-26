package com.project.spring_bean_concepts.qualifier_annotation;


import org.springframework.stereotype.Service;

@Service
public class CardPaymentService implements PaymentService{
    @Override
    public void doPayment() {
        System.out.println("Calling Card Payment Service");
    }
}
