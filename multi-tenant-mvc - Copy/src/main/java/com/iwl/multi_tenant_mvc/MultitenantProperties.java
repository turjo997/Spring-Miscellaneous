package com.iwl.multi_tenant_mvc;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties
public class MultitenantProperties {
    // This will map to the "tenants" block in your YAML
    // The key is the tenant ID (e.g., "tenant_1")
    // The value is Spring's own DataSourceProperties class
    private final Map<String, DataSourceProperties> tenants = new HashMap<>();

    public Map<String, DataSourceProperties> getTenants() {
        return tenants;
    }
}
