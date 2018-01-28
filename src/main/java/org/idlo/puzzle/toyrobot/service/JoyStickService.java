package org.idlo.puzzle.toyrobot.service;

import org.idlo.puzzle.toyrobot.core.Robot;
import org.idlo.puzzle.toyrobot.core.exception.TransformationException;
import org.idlo.puzzle.toyrobot.core.instruction.BaseInstruction;

/**
 * @author akshay.zaveri
 * This class will be implementing all the features required to operate the robot.
 * It will extend the @{@link BaseAbstractService}
 */
public interface JoyStickService extends BaseAbstractService{

    /**
     * This method will accept the instruction and respond accordingly.
     * @param baseInstruction
     * @param robot
     */
    Robot transform(Robot robot, BaseInstruction baseInstruction) throws TransformationException;

    /**
     * This class will simply return the current robot object.
     * @return
     */
    Robot report();

}
