package com.iwl.multi_tenant.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class TenantFilter {

    private static final String DEFAULT_TENANT = "public";

    public void doFilter(ServletRequest req, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String tenantId = request.getHeader("X-Tenant-ID");
        if(tenantId == null || tenantId.isBlank()){
            tenantId = DEFAULT_TENANT;
        }
        TenantContext.setCurrentTenant(tenantId);
        try {
            chain.doFilter(req, response);
        }catch (Exception e){
            TenantContext.clear();
        }
    }


}
