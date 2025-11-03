package com.iwl.multi_tenant_mvc.repo;

import com.iwl.multi_tenant_mvc.masterDomain.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
    Optional<Tenant> findByTenantId(String tenantId);
}
