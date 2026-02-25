package com.admission.crm.exception;

import com.admission.crm.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle Business Rule Violations
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<Object>> handleBusinessException(BusinessException ex) {
        return new ResponseEntity<>(
                ApiResponse.failure(ex.getMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    // Handle Not Found Errors
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleNotFound(ResourceNotFoundException ex) {
        return new ResponseEntity<>(
                ApiResponse.failure(ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    // Handle Validation Errors (@Valid)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidation(MethodArgumentNotValidException ex) {

        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        return new ResponseEntity<>(
                ApiResponse.failure(errorMessage),
                HttpStatus.BAD_REQUEST
        );
    }

    // Catch All Unexpected Errors
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGeneral(Exception ex) {

        return new ResponseEntity<>(
                ApiResponse.failure("Internal Server Error: " + ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}