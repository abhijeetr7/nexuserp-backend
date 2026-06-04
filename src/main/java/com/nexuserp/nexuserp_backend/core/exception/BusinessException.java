package com.nexuserp.nexuserp_backend.core.exception;

public class BusinessException
        extends RuntimeException {

    public BusinessException(
            String message) {

        super(message);
    }
}