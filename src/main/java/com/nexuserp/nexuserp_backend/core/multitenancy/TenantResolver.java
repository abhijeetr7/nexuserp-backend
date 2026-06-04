package com.nexuserp.nexuserp_backend.core.multitenancy;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class TenantResolver {

    public String resolveTenant(
            HttpServletRequest request) {

        return request.getHeader(
                "X-Tenant-Code");
    }
}