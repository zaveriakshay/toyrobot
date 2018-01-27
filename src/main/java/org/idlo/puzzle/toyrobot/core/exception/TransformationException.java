package org.idlo.puzzle.toyrobot.core.exception;

import org.idlo.puzzle.toyrobot.core.enums.ErrorType;

/**
 * @author akshay.zaveri
 */
public class TransformationException extends BaseException {

    public TransformationException(String message) {
        super(message);
    }

    public TransformationException(ErrorType errorType) {
        super(errorType);
    }
}
