package com.iwl.multi_tenant_mvc;

public class TenantContext {

    private static final ThreadLocal<String> currentTenant = new ThreadLocal<String>();

    private TenantContext(){}

    public static void setCurrentTenant(String tenant){
        currentTenant.set(tenant);
        System.out.println("[TenantContext] Set tenant: " + tenant);
    }

    public static String getCurrentTenant(){
        return currentTenant.get();
    }
    public static void clear(){
        System.out.println("[TenantContext] Cleared tenant context");
        currentTenant.remove();
    }

}
