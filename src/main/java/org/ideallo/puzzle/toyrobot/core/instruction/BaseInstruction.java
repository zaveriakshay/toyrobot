package org.ideallo.puzzle.toyrobot.core.instruction;

import org.ideallo.puzzle.toyrobot.core.Base;
import org.ideallo.puzzle.toyrobot.core.command.*;
import org.ideallo.puzzle.toyrobot.core.enums.DirectionType;
import org.ideallo.puzzle.toyrobot.core.enums.RotationType;
import org.ideallo.puzzle.toyrobot.core.enums.TransformationType;
import org.ideallo.puzzle.toyrobot.core.vector.Coordinates;

/**
 * @author akshay.zaveri
 */
public abstract class BaseInstruction extends Base {

    private static final long serialVersionUID = -4651279752591398871L;

    private TransformationType transformationType;

    private BaseTransformationCommand transformationCommand;

    public TransformationType getTransformationType() {
        return transformationType;
    }

    public void setTransformationType(TransformationType transformationType) {
        this.transformationType = transformationType;
    }

    public BaseTransformationCommand getTransformationCommand() {
        return transformationCommand;
    }

    public void setTransformationCommand(BaseTransformationCommand transformationCommand) {
        this.transformationCommand = transformationCommand;
    }
}
