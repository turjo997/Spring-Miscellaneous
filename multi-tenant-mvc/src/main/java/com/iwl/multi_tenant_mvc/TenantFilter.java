package com.iwl.multi_tenant_mvc;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
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

        //this one is for rest api

//        String tenantName = req.getHeader("X-TenantID");
//        TenantContext.setCurrentTenant(tenantName);
//
//        try {
//            chain.doFilter(request, response);
//        } finally {
////            TenantContext.setCurrentTenant("");
//            TenantContext.clear();
//        }


        //this one is for mvc pattern

        String tenantName = req.getParameter("tenant"); // support query param now
        if (tenantName == null) {
            tenantName = req.getHeader("X-TenantID");
        }

        TenantContext.setCurrentTenant(tenantName);
        try {
            chain.doFilter(request, response);
        } finally {
            TenantContext.clear();
        }
    }
}