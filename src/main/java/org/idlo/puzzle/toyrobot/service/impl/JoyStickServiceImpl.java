package org.idlo.puzzle.toyrobot.service.impl;

import org.idlo.puzzle.toyrobot.core.Robot;
import org.idlo.puzzle.toyrobot.core.enums.ErrorType;
import org.idlo.puzzle.toyrobot.core.exception.RobotMissingException;
import org.idlo.puzzle.toyrobot.core.exception.TransformationException;
import org.idlo.puzzle.toyrobot.core.instruction.BaseInstruction;
import org.idlo.puzzle.toyrobot.service.JoyStickService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * This method will accept the instructions and respond accordingly.
     * It can handle the instructions for place, move, left and right instructions from user.
     * @param robot
     * @param baseInstruction
     * @return
     * @throws TransformationException
     */
    @Override
    public Robot transform(Robot robot, BaseInstruction baseInstruction) throws TransformationException {
        debug("transform:is called");
        return (Robot) baseInstruction.getTransformationCommand().executeCommand(robot);
    }

    /**
     * This method will simply return the robot object
     * @return
     */
    @Override
    public Robot report() throws TransformationException {
        debug("report:is called");
        if (!getRobot().getPlaced()) {
            throw new RobotMissingException(ErrorType.ERR0005);
        }
        return getRobot();
    }

    @Override
    public Robot fetchRobot() {
        return getRobot();
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }
}


