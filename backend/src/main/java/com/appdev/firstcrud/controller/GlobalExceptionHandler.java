package com.appdev.firstcrud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.appdev.firstcrud.response.NameErrorResponse;
import com.appdev.firstcrud.service.NameNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<NameErrorResponse> handleBadRequest(HttpMessageNotReadableException ex) {
        NameErrorResponse r = new NameErrorResponse();
        r.setStatus(HttpStatus.BAD_REQUEST.value());
        r.setMessage("Request body is missing or malformed");
        r.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(r, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NameNotFoundException.class)
    public ResponseEntity<NameErrorResponse> handleNotFound(NameNotFoundException ex) {
        NameErrorResponse r = new NameErrorResponse();
        r.setStatus(HttpStatus.NOT_FOUND.value());
        r.setMessage(ex.getMessage());
        r.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);
    }
}
