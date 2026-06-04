package com.nexuserp.nexuserp_backend.modules.tenant.controller;

import com.nexuserp.nexuserp_backend.core.security.AesEncryptionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final AesEncryptionService aesService;

    public TestController(
            AesEncryptionService aesService) {

        this.aesService = aesService;
    }

    @GetMapping("/test-encryption")
    public String testEncryption() {

        String encrypted =
                aesService.encrypt("root");

        String decrypted =
                aesService.decrypt(encrypted);

        return "Encrypted: "
                + encrypted
                + " | Decrypted: "
                + decrypted;
    }
}