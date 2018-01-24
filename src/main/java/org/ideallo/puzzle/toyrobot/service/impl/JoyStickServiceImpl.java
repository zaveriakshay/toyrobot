package org.ideallo.puzzle.toyrobot.service.impl;

import org.ideallo.puzzle.toyrobot.core.command.Instruction;
import org.ideallo.puzzle.toyrobot.core.command.TransformationCommand;
import org.ideallo.puzzle.toyrobot.core.object.Robot;
import org.ideallo.puzzle.toyrobot.service.JoyStickService;

/**
 * @author akshay.zaveri
 * This service implementation class will implement all the operations defined under the @{@link JoyStickService} and also extend the @{@link BaseAbstractServiceImpl}
 * generic service layer implementation.
 */
public class JoyStickServiceImpl extends BaseAbstractServiceImpl implements JoyStickService{

    @Override
    public Robot transform(Robot robot, Instruction instruction) {
        return null;
    }

    @Override
    public Robot output() {
        return null;
    }
}


