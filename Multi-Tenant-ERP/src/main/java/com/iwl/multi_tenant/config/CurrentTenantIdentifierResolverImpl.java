package com.iwl.multi_tenant.config;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class CurrentTenantIdentifierResolverImpl implements CurrentTenantIdentifierResolver {
    private static final String DEFAULT_TENANT = "public";

    @Override
    public Object resolveCurrentTenantIdentifier() {
        String t = TenantContext.getCurrentTenant();
        return t != null ? t : DEFAULT_TENANT;
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
