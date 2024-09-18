package com.spring.entity_data_validation.handler;

import com.spring.entity_data_validation.exception.AuthorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> handleMethodArgumentException(MethodArgumentNotValidException exception){
        Map<String,String> errorMap = new HashMap<>();

        exception.getBindingResult().getFieldErrors().forEach(error->
                errorMap.put(error.getField() , error.getDefaultMessage())
                );

        return errorMap;
    }



    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(AuthorNotFoundException.class)
    public Map<String,String> handleBusinessException(AuthorNotFoundException exception){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("errorMessage" , exception.getMessage());
        return errorMap;
    }





}
