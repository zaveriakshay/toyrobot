package org.ideallo.puzzle.toyrobot.controller;

import org.ideallo.puzzle.toyrobot.core.exception.BindingException;
import org.ideallo.puzzle.toyrobot.core.exception.TransformationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.List;

import static org.ideallo.puzzle.toyrobot.core.constants.AppConstants._OOPS_SERVER_MALFUNCTION;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {TransformationException.class, BindingException.class,Exception.class})
    protected Object handleConflict(RuntimeException ex, WebRequest request) {
        Object errorMessage = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/report"));
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        if(ex instanceof TransformationException){
            //return ex;
            errorMessage = ex.getMessage();
            httpStatus = HttpStatus.FORBIDDEN;
        }else if(ex instanceof BindingException){
            //return ex;
            errorMessage = ex.getMessage();
            errorMessage = ((BindingException) ex).getBindingResult();
            httpStatus = HttpStatus.BAD_REQUEST;
        }else{
            errorMessage = _OOPS_SERVER_MALFUNCTION+ex.getMessage();
        };

        return handleExceptionInternal(ex, errorMessage,headers, httpStatus, request);
     }

}