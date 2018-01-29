package org.idlo.puzzle.toyrobot.core.exception;

import org.idlo.puzzle.toyrobot.core.enums.ErrorType;

/**
 * @author akshay.zaveri
 * This class is the Robot Missing Exception, will be used to handle and repsent any kind of internal
 * exceptions when robot is not places and instructions are invoked.
 */
public class RobotMissingException extends TransformationException {

    private static final long serialVersionUID = -5560703167471313968L;

    public RobotMissingException(String message) {
        super(message);
    }

    public RobotMissingException(ErrorType errorType) {
        super(errorType);
    }
}
