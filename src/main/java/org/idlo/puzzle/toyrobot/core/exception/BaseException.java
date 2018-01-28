package org.idlo.puzzle.toyrobot.core.exception;

import org.idlo.puzzle.toyrobot.core.enums.ErrorType;

/**
 * @author akshay.zaveri
 * This is the root class for all the exceptions in the application.
 */
public class BaseException extends Exception {

    private static final long serialVersionUID = -6186262781159953084L;

    private ErrorType errorType;

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }

    public BaseException() {

    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(ErrorType errorType){
        setErrorType(errorType);
    }
}
