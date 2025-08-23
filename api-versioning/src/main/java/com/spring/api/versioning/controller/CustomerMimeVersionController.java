package com.spring.api.versioning.controller;

import com.spring.api.versioning.model.CustomerV1;
import com.spring.api.versioning.model.CustomerV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerMimeVersionController {

    // in cmd terminal type the following to get the response

    //curl -H "Accept: application/vnd.company.app-v1+json" http://localhost:8080/api/customers
    //curl -H "Accept: application/vnd.company.app-v2+json" http://localhost:8080/api/customers

    @GetMapping(produces = "application/vnd.company.app-v1+json")
    public CustomerV1 getCustomerV1() {
        return new CustomerV1("John Doe");
    }

    @GetMapping(produces = "application/vnd.company.app-v2+json")
    public CustomerV2 getCustomerV2() {
        return new CustomerV2(1, "John Doe");
    }


}
