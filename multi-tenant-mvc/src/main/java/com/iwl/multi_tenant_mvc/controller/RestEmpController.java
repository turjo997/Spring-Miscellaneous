package com.iwl.multi_tenant_mvc.controller;


import com.iwl.multi_tenant_mvc.domain.Employee;
import com.iwl.multi_tenant_mvc.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class RestEmpController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/emp")
    public ResponseEntity<?> createEmployee() {
        Employee newEmployee = new Employee();
        newEmployee.setName("Baeldung");
        employeeRepository.save(newEmployee);
        return ResponseEntity.ok(newEmployee);
    }
}
