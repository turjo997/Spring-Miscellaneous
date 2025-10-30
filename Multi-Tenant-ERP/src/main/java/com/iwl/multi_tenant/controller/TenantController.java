package com.iwl.multi_tenant.controller;

import com.iwl.multi_tenant.entity.Customer;
import com.iwl.multi_tenant.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tenants")
public class TenantController {

    private final TenantService tenantService;
    @Autowired
    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping
    public ResponseEntity<String> createTenant(@RequestParam String tenantId){
        tenantService.createTenantSchema(tenantId);
        return ResponseEntity.ok("Tenant create: " + tenantId);
    }
}
