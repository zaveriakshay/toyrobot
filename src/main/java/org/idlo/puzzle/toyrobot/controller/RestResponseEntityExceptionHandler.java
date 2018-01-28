package org.idlo.puzzle.toyrobot.controller;

import org.idlo.puzzle.toyrobot.core.enums.ErrorType;
import org.idlo.puzzle.toyrobot.core.exception.BindingException;
import org.idlo.puzzle.toyrobot.core.exception.Error;
import org.idlo.puzzle.toyrobot.core.exception.TransformationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

/**
 * @author akshay.zaveri
 * This class is the exception handler for the controller.
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    MessageSource messageSource;

    /**
     * This method will hadnle all kinds of exceptions.
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value = {BindingException.class,TransformationException.class, Exception.class})
    protected @ResponseBody ResponseEntity<? super Error> handleConflict(Exception ex, WebRequest request) {
        debug("handleConflict:is called");
        String errorDetails = "";
        Error error = null;
        HttpHeaders headers = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        if(ex instanceof TransformationException){
            debug("handleConflict:is called for TransformationException");
            error = new Error(((TransformationException) ex).getErrorType(),errorDetails,messageSource);
            httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<Error>(error,httpStatus);
        }else if(ex instanceof BindingException){
            debug("handleConflict:is called for BindingException");
            errorDetails = ex.getMessage();
            error = new Error(((BindingException) ex).getErrorType(),errorDetails,messageSource);
            httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<Error>(error,httpStatus);
        }else{
            debug("handleConflict:is called for Exceptions");
            error = new Error(ErrorType.ERR0003,errorDetails,messageSource);
        }

        return handleExceptionInternal(ex, error,headers, httpStatus, request);
     }

    private void debug(String s) {
        logger.debug(s);
    }
}