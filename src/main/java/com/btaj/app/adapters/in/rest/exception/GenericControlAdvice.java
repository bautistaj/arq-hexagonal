package com.btaj.app.adapters.in.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GenericControlAdvice {

    @ResponseBody
    @ExceptionHandler(HeadquarterNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String headquarterNotFoundHandler(HeadquarterNotFoundException ex){
        return ex.getMessage();
    }
}
