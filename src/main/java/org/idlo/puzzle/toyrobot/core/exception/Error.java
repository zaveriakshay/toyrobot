package org.idlo.puzzle.toyrobot.core.exception;

import org.idlo.puzzle.toyrobot.core.Base;
import org.idlo.puzzle.toyrobot.core.enums.ErrorType;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

/**
 * @author akshay.zaveri
 * This class Error, will be returned to the end user, in a json format.
 */
public class Error extends Base{

    private static final long serialVersionUID = -656989706661989557L;

    private ErrorType errorCode;

    private String errorMessage;

    private String errorDetails;

    public Error(ErrorType errorCode, String errorDetails, MessageSource messageSource) {
        this.errorCode = errorCode;
        this.errorMessage = messageSource.getMessage(errorCode.getKey(),null, Locale.getDefault());
        this.errorDetails = errorDetails;
    }

    public ErrorType getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorType errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }
}
