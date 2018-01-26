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
public class TranslationInstruction extends BaseInstruction {

    private static final long serialVersionUID = -4651279752591398871L;

    public TranslationInstruction(){
        setTransformationType(TransformationType.TRANSLATE);
        setTransformationCommand(new TranslationCommand());
    }
}
