package com.kpezesha.MoneyTransfer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;
@RestControllerAdvice //centralized place for handling exceptions in all controllers.
public class GlobalExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)// Catches validation errors and returns a 400 BAD REQUEST response with details about the constraint violation.
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class) // Handles any other unexpected exceptions and returns a generic error message with a 500 INTERNAL SERVER ERROR status.
    public ResponseEntity<Object> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + ex.getMessage());
    }
}
