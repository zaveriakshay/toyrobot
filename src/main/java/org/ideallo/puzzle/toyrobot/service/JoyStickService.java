package org.ideallo.puzzle.toyrobot.service;

import org.ideallo.puzzle.toyrobot.core.instruction.BaseInstruction;
import org.ideallo.puzzle.toyrobot.core.Robot;

/**
 * @author akshay.zaveri
 * This class will be implementing all the features required to operate the robot.
 * It will extend the @{@link BaseAbstractService}
 */
public interface JoyStickService extends BaseAbstractService{

    /**
     * This method will accept the command type vector and respond accordingly.
     * @param baseInstruction
     * @param robot
     */
    public Robot transform(Robot robot, BaseInstruction baseInstruction);

    public Robot report();

}
