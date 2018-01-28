package org.idlo.puzzle.toyrobot.core.instruction;

import org.idlo.puzzle.toyrobot.core.Base;
import org.idlo.puzzle.toyrobot.core.command.BaseTransformationCommand;
import org.idlo.puzzle.toyrobot.core.enums.TransformationType;

/**
 * @author akshay.zaveri
 * This class will represent all kinds of instructions in the application.
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
