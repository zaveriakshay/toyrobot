package org.idlo.puzzle.toyrobot.controller;

import org.idlo.puzzle.toyrobot.core.enums.ErrorType;
import org.idlo.puzzle.toyrobot.core.exception.BindingException;
import org.idlo.puzzle.toyrobot.core.exception.Error;
import org.idlo.puzzle.toyrobot.core.exception.TransformationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    MessageSource messageSource;

    @ExceptionHandler(value = {BindingException.class,TransformationException.class, Exception.class})
    protected @ResponseBody ResponseEntity<? super Error> handleConflict(Exception ex, WebRequest request) {
        String errorDetails = "";
        Error error = null;
        HttpHeaders headers = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        if(ex instanceof TransformationException){
            error = new Error(((TransformationException) ex).getErrorType(),errorDetails,messageSource);
            httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<Error>(error,httpStatus);
        }else if(ex instanceof BindingException){
            errorDetails = ex.getMessage();
            error = new Error(((BindingException) ex).getErrorType(),errorDetails,messageSource);
            httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<Error>(error,httpStatus);
        }else{
            error = new Error(ErrorType.ERR0003,errorDetails,messageSource);
        }

        return handleExceptionInternal(ex, error,headers, httpStatus, request);
     }

}