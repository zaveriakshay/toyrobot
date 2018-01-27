package org.idlo.puzzle.toyrobot.core.instruction;

import org.idlo.puzzle.toyrobot.core.command.RotationCommand;
import org.idlo.puzzle.toyrobot.core.enums.RotationType;
import org.idlo.puzzle.toyrobot.core.enums.TransformationType;

/**
 * @author akshay.zaveri
 */
public class RotationInstruction extends BaseInstruction {

    private static final long serialVersionUID = -4651279752591398871L;

    public RotationInstruction(RotationType rotationType){
        setTransformationType(TransformationType.ROTATE);
        setTransformationCommand(new RotationCommand(rotationType));
    }

}
