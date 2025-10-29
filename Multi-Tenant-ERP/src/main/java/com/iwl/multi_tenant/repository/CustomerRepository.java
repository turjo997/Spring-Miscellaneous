package com.iwl.multi_tenant.repository;

import com.iwl.multi_tenant.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
