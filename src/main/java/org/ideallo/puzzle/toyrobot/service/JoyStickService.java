package org.ideallo.puzzle.toyrobot.service;

import org.ideallo.puzzle.toyrobot.core.command.Instruction;
import org.ideallo.puzzle.toyrobot.core.command.TransformationCommand;
import org.ideallo.puzzle.toyrobot.core.object.Robot;
import org.springframework.stereotype.Service;

/**
 * @author akshay.zaveri
 * This class will be implementing all the features required to operate the robot.
 * It will extend the @{@link BaseAbstractService}
 */
public interface JoyStickService extends BaseAbstractService{

    /**
     * This method will accept the command type object and respond accordingly.
     * @param instruction
     * @param robot
     */
    public Robot transform(Robot robot, Instruction instruction);

    public Robot report();

}
