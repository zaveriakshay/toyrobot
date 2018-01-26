package org.ideallo.puzzle.toyrobot.controller;

import org.ideallo.puzzle.toyrobot.core.vector.TransformationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

import static org.ideallo.puzzle.toyrobot.core.constants.AppConstants._OOPS_SERVER_MALFUNCTION;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {TransformationException.class, Exception.class})
    protected Object handleConflict(RuntimeException ex, WebRequest request) {
        String errorMessage = null;
        if(ex instanceof TransformationException){
            errorMessage = ex.getMessage();
            return ex;
        }else{
            errorMessage = _OOPS_SERVER_MALFUNCTION;
        };
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/report"));
        return handleExceptionInternal(ex, errorMessage,headers, HttpStatus.CONFLICT, request);
     }
}