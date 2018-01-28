package org.idlo.puzzle.toyrobot.core.exception;

import org.idlo.puzzle.toyrobot.core.enums.ErrorType;

/**
 * @author akshay.zaveri
 * This class is the Transformation Exception, will be used to handle and repsent any kind of internal
 * exceptions.
 */
public class TransformationException extends BaseException {

    public TransformationException(String message) {
        super(message);
    }

    public TransformationException(ErrorType errorType) {
        super(errorType);
    }
}
