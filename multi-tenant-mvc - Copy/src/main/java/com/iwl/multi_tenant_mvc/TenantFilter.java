package com.iwl.multi_tenant_mvc;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(1)
public class TenantFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        // First, try to get tenant from session
        HttpSession session = req.getSession(false);
        String tenantName = null;
        if (session != null) {
            tenantName = (String) session.getAttribute("TENANT");
        }

        // Fallback to query parameter or header if not in session (for login page)
        if (tenantName == null) {
            tenantName = req.getParameter("tenant");
        }
        if (tenantName == null) {
            tenantName = req.getHeader("X-TenantID");
        }

        // Set tenant context for this thread
        TenantContext.setCurrentTenant(tenantName);

        try {
            chain.doFilter(request, response);
        } finally {
            TenantContext.clear();
        }
    }
}
