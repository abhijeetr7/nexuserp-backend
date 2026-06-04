package com.nexuserp.nexuserp_backend.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nexuserp.nexuserp_backend.core.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>>
    handleNotFound(
            ResourceNotFoundException ex) {

        return ResponseEntity.status(
                HttpStatus.NOT_FOUND)

                .body(new ApiResponse<>(
                        false,
                        ex.getMessage(),
                        null));
    }

    @ExceptionHandler(
            BusinessException.class)
    public ResponseEntity<ApiResponse<Void>>
    handleBusiness(
            BusinessException ex) {

        return ResponseEntity.badRequest()

                .body(new ApiResponse<>(
                        false,
                        ex.getMessage(),
                        null));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>>
    handleGeneric(Exception ex) {

        ex.printStackTrace();

        return ResponseEntity.status(
                HttpStatus.INTERNAL_SERVER_ERROR)

                .body(new ApiResponse<>(
                        false,
                        ex.getMessage(),
                        null));
    }
}