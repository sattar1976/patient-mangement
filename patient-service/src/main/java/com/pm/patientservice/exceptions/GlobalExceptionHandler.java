package com.pm.patientservice.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentException(MethodArgumentNotValidException methArgException)
    {
        Map<String, String> validationErrors = new HashMap<>();
        methArgException.getBindingResult().getFieldErrors().forEach(
                error -> validationErrors.put(error.getField(),error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(validationErrors);

    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePatientNotFoundException(PatientNotFoundException patientNotFoundException)
    {
        log.warn("patinent not found: {}",patientNotFoundException.getMessage());
        Map<String, String> validationErrors = new HashMap<>();
        validationErrors.put("message","Patient Not Found");
        return ResponseEntity.badRequest().body(validationErrors);

    }
@ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleEmailAlreadyExistsException(EmailAlreadyExistsException emailAlreadyExistsException)
{
log.warn ("Email Address already in use");
    Map<String, String> validationErrors = new HashMap<>();
    validationErrors.put("message","Email already Exists");
    return ResponseEntity.badRequest().body(validationErrors);

}

}
