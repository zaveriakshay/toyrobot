package org.idlo.puzzle.toyrobot.core.exception;

import org.idlo.puzzle.toyrobot.core.enums.ErrorType;

/**
 * @author akshay.zaveri
 * This class is the Transformation Exception, will be used to handle and repsent any kind of internal
 * exceptions, when there is any issue with transformation of the robot.
 */
public class TransformationException extends BaseException {

    private static final long serialVersionUID = -4092825134365615219L;

    public TransformationException(String message) {
        super(message);
    }

    public TransformationException(ErrorType errorType) {
        super(errorType);
    }
}
