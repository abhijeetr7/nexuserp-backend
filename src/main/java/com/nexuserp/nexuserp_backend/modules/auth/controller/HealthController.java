package com.nexuserp.nexuserp_backend.modules.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "NexusERP Backend Running";
    }
}
