package com.spring.api.versioning.controller;

import com.spring.api.versioning.model.CustomerV1;
import com.spring.api.versioning.model.CustomerV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerUriVersionController {

    @GetMapping("/v1/customers")
    public CustomerV1 getCustomerV1(){
        return new CustomerV1("John Doe");
    }

    @GetMapping("/v2/customers")
    public CustomerV2 getCustomerV2(){
        return new CustomerV2(1 , "John Doe");
    }
}
