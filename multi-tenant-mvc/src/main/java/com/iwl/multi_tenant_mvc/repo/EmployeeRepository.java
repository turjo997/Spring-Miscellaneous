package com.iwl.multi_tenant_mvc.repo;

import com.iwl.multi_tenant_mvc.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
