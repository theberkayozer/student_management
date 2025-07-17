package com.example.studentmanager.exception;

import aj.org.objectweb.asm.Handle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException exception) {
    Map <String,String> errors = new HashMap<>();
    for(FieldError fieldError :exception.getBindingResult().getFieldErrors() ){
        String fieldName = fieldError.getField();
        String errorMessage = fieldError.getDefaultMessage();
        errors.put(fieldName,errorMessage);
    }
    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
