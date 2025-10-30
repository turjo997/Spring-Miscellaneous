package com.iwl.multi_tenant.controller;

import com.iwl.multi_tenant.entity.Customer;
import com.iwl.multi_tenant.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository repo;

    public CustomerController(CustomerRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return repo.save(customer);
    }

    @GetMapping
    public List<Customer> all() {
        return repo.findAll();
    }

}
