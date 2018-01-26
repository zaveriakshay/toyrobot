package org.ideallo.puzzle.toyrobot.core.exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

/**
 * @author akshay.zaveri
 */
public class BindingException extends RuntimeException {

    private BindingResult bindingResult;

    public BindingException() {

    }

    public BindingException(String message,BindingResult bindingResult) {
        super(message);
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public void setBindingResult(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }
}
