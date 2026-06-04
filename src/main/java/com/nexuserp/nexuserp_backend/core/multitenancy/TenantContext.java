package com.nexuserp.nexuserp_backend.core.multitenancy;

public class TenantContext {

    private static final ThreadLocal<String>
            CURRENT_TENANT =
            new ThreadLocal<>();

    public static void setTenant(
            String tenantCode) {

        CURRENT_TENANT.set(
                tenantCode);
    }

    public static String getTenant() {

        return CURRENT_TENANT.get();
    }

    public static void clear() {

        CURRENT_TENANT.remove();
    }
}