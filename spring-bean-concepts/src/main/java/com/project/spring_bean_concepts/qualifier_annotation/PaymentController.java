package com.project.spring_bean_concepts.qualifier_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class PaymentController {

    @Autowired
    @Qualifier("cashPaymentService")
    private PaymentService service;

    public void getPayment(){
        service.doPayment();
    }
}
