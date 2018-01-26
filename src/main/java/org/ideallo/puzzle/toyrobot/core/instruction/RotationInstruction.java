package org.ideallo.puzzle.toyrobot.core.instruction;

import org.ideallo.puzzle.toyrobot.core.Base;
import org.ideallo.puzzle.toyrobot.core.command.PositionCommand;
import org.ideallo.puzzle.toyrobot.core.command.RotationCommand;
import org.ideallo.puzzle.toyrobot.core.command.TransformationCommand;
import org.ideallo.puzzle.toyrobot.core.command.TranslationCommand;
import org.ideallo.puzzle.toyrobot.core.enums.RotationType;
import org.ideallo.puzzle.toyrobot.core.enums.TransformationType;
import org.ideallo.puzzle.toyrobot.core.vector.Coordinates;

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
