package org.idlo.puzzle.toyrobot.core.instruction;

import org.idlo.puzzle.toyrobot.core.command.RotationCommand;
import org.idlo.puzzle.toyrobot.core.enums.RotationType;
import org.idlo.puzzle.toyrobot.core.enums.TransformationType;

/**
 * @author akshay.zaveri
 * This class is the instruction to represent any left/right command recieved.
 */
public class RotationInstruction extends BaseInstruction {

    private static final long serialVersionUID = -904465369089943625L;

    public RotationInstruction(RotationType rotationType){
        setTransformationType(TransformationType.ROTATE);
        setTransformationCommand(new RotationCommand(rotationType));
    }

}
