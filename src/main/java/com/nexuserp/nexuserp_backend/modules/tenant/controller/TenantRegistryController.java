package com.nexuserp.nexuserp_backend.modules.tenant.controller;

import com.nexuserp.nexuserp_backend.core.multitenancy.TenantContext;
import com.nexuserp.nexuserp_backend.modules.tenant.dto.CreateTenantRequest;
import com.nexuserp.nexuserp_backend.modules.tenant.service.TenantRegistryService;
import com.nexuserp.nexuserp_backend.modules.tenant.dto.TenantResponse;
import com.nexuserp.nexuserp_backend.modules.tenant.dto.UpdateTenantRequest;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tenants")
public class TenantRegistryController {


    
    @Autowired
	private TenantRegistryService service;

    @PostMapping
    public TenantResponse createTenant(
            @Valid @RequestBody CreateTenantRequest request) {
        return service.createTenant(request);
    }

    @GetMapping
    public List<TenantResponse> getAllTenants() {
        return service.getAllTenants();
    }

    @GetMapping("/{id}")
    public TenantResponse getTenantById(
            @PathVariable Long id) {

        return service.getTenantById(id);
    }
    
    @PutMapping("/{id}")
    public TenantResponse updateTenant(
            @PathVariable Long id,
            @RequestBody UpdateTenantRequest request) {

        return service.updateTenant(
                id,
                request);
    }
    
    @DeleteMapping("/{id}")
    public String deleteTenant(
            @PathVariable Long id) {

        service.deleteTenant(id);

        return "Tenant deleted successfully";
    }
    
}
