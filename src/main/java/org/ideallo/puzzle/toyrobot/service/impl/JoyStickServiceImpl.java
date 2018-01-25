package org.ideallo.puzzle.toyrobot.service.impl;

import org.ideallo.puzzle.toyrobot.core.command.Instruction;
import org.ideallo.puzzle.toyrobot.core.command.TransformationCommand;
import org.ideallo.puzzle.toyrobot.core.object.Robot;
import org.ideallo.puzzle.toyrobot.service.JoyStickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author akshay.zaveri
 * This service implementation class will implement all the operations defined under the @{@link JoyStickService} and also extend the @{@link BaseAbstractServiceImpl}
 * generic service layer implementation.
 */

@Service
public class JoyStickServiceImpl extends BaseAbstractServiceImpl implements JoyStickService{

    @Autowired
    private Robot robot;

    @Override
    public Robot transform(Robot robot, Instruction instruction) {
        return (Robot)instruction.getTransformationCommand().executeCommand(robot);
    }

    @Override
    public Robot report() {
        return robot;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }
}


