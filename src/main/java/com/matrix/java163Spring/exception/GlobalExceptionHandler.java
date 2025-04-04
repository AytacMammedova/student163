package com.matrix.java163Spring.exception;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
@Hidden
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {UserNotFound.class})
    public ResponseEntity<Object> handleNotFoundException(UserNotFound e){
        HttpStatus httpStatus=HttpStatus.NOT_FOUND;
        ErrorResponse response = new ErrorResponse(e.getMessage(), httpStatus, LocalDateTime.now());
        return new ResponseEntity<>(response, httpStatus);
    }
}
