package org.idlo.puzzle.toyrobot.core.exception;

import org.idlo.puzzle.toyrobot.core.enums.ErrorType;
import org.springframework.validation.BindingResult;

/**
 * @author akshay.zaveri
 * This is the root Binding Exceptoin claass for the entire application.
 */
public class BindingException extends RuntimeException {

    private static final long serialVersionUID = 3228677799966469342L;

    private ErrorType errorType;

    private transient BindingResult bindingResult;

    public BindingException(String message,BindingResult bindingResult,ErrorType errorType) {
        super(message);
        setBindingResult(bindingResult);
        setErrorType(errorType);
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public void setBindingResult(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }
}
