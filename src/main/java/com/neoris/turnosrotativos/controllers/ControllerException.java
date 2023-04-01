package com.neoris.turnosrotativos.controllers;

import com.neoris.turnosrotativos.exceptions.ApiExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerException {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  ResponseEntity<?> handleValidationEx(MethodArgumentNotValidException ex){
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach(error -> {
      String fieldName = ((FieldError)error).getField();
      String message = error.getDefaultMessage();

      errors.put(fieldName, message);
    });

    return  new ResponseEntity<>(new ApiExceptionResponse(errors, HttpStatus.CONFLICT), HttpStatus.BAD_REQUEST);
  }
}
