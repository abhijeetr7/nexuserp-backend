package com.nexuserp.nexuserp_backend.core.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AesEncryptionService {

    @Value("${nexuserp.aes.secret}")
    private String secretKey;

    private SecretKeySpec getKey() {

        return new SecretKeySpec(
                secretKey.getBytes(StandardCharsets.UTF_8),
                "AES");
    }

    public String encrypt(String value) {

        try {

            Cipher cipher =
                    Cipher.getInstance("AES");

            cipher.init(
                    Cipher.ENCRYPT_MODE,
                    getKey());

            byte[] encrypted =
                    cipher.doFinal(
                            value.getBytes(
                                    StandardCharsets.UTF_8));

            return Base64.getEncoder()
                    .encodeToString(encrypted);

        } catch (Exception ex) {

            throw new RuntimeException(
                    "Error while encrypting",
                    ex);
        }
    }

    public String decrypt(String value) {

        try {

            Cipher cipher =
                    Cipher.getInstance("AES");

            cipher.init(
                    Cipher.DECRYPT_MODE,
                    getKey());

            byte[] decrypted =
                    cipher.doFinal(
                            Base64.getDecoder()
                                    .decode(value));

            return new String(
                    decrypted,
                    StandardCharsets.UTF_8);

        } catch (Exception ex) {

            throw new RuntimeException(
                    "Error while decrypting",
                    ex);
        }
    }
}