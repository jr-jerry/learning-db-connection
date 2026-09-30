package com.Ducat.learning_db_connection.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = DuplicateUserException.class)
    public ResponseEntity<?> handleDuplicateUserException(DuplicateUserException e){
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("user already exist");
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        Map<String,String> errorResponse=new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach(error->{
            errorResponse.put(error.getField(),error.getDefaultMessage());
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
