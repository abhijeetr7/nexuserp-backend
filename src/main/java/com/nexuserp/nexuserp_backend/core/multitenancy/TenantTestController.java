package com.nexuserp.nexuserp_backend.core.multitenancy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TenantTestController {

    @GetMapping("/tenant")
    public String testTenant() {

    	return TenantContext.getTenant();
    }
    
    @GetMapping("/tenant-info")
    public String tenantInfo() {

        String tenantCode =
                TenantContext.getTenant();

        if (tenantCode == null) {
            return "NO TENANT HEADER";
        }

        return tenantCode;
    }
}