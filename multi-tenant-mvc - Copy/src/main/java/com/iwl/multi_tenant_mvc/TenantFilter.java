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

//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest req = (HttpServletRequest) request;
//
//        // Always start clean to avoid tenant bleed
//        TenantContext.clear();
//
//        String tenant = null;
//
//        // Priority 1: Check if the URL has a pattern like /auth/login/{tenant} or /something/{tenant}
//        String uri = req.getRequestURI();
//        String[] parts = uri.split("/");
//        for (int i = 0; i < parts.length; i++) {
//            if ("login".equals(parts[i]) || "logout".equals(parts[i])) {
//                if (i + 1 < parts.length) {
//                    tenant = parts[i + 1];
//                    break;
//                }
//            }
//        }
//
//        // Priority 2: Check request parameter
//        if (tenant == null) {
//            tenant = req.getParameter("tenant");
//        }
//
//        // Priority 3: Check header (optional)
//        if (tenant == null) {
//            tenant = req.getHeader("X-TenantID");
//        }
//
//        // Priority 4: Check session (if logged in)
//        if (tenant == null) {
//            HttpSession session = req.getSession(false);
//            if (session != null) {
//                tenant = (String) session.getAttribute("TENANT");
//            }
//        }
//
//        // Finally, set the tenant in context
//        if (tenant != null) {
//            TenantContext.setCurrentTenant(tenant);
//        }
//
//        try {
//            chain.doFilter(request, response);
//        } finally {
//            // Always clear at the end of each request
//            TenantContext.clear();
//        }
//    }

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
