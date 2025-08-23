package com.spring.api.versioning.controller;

import com.spring.api.versioning.model.CustomerV1;
import com.spring.api.versioning.model.CustomerV2;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerSubdomainController {

    // in cmd terminal type the following to get the response

    //curl -H "Host: v1.localhost" http://localhost:8080/customers
    //curl -H "Host: v2.localhost" http://localhost:8080/customers



    @GetMapping("/customers")
    public Object getCustomer(HttpServletRequest request) {
        String host = request.getHeader("Host");

        if (host != null && host.startsWith("v1.")) {
            return new CustomerV1("John Doe");
        } else if (host != null && host.startsWith("v2.")) {
            return new CustomerV2(1, "John Doe");
        }
        return "Unsupported version";
    }

}
