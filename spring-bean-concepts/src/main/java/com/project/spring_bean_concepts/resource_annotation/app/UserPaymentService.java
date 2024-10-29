package com.project.spring_bean_concepts.resource_annotation.app;

import com.project.spring_bean_concepts.resource_annotation.api.Payment;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;


@Component
public class UserPaymentService {

    @Resource(name = "paymentBean")
    private Payment payment;

    public String processPayment(){
        return payment.doTransaction();
    }
}
