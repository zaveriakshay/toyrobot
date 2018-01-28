package org.idlo.puzzle.toyrobot.core.instruction;

import org.idlo.puzzle.toyrobot.core.command.TranslationCommand;
import org.idlo.puzzle.toyrobot.core.enums.TransformationType;

/**
 * @author akshay.zaveri
 * This class is the instruction to represent any move command recieved.
 */
public class TranslationInstruction extends BaseInstruction {

    private static final long serialVersionUID = -4651279752591398871L;

    public TranslationInstruction(){
        setTransformationType(TransformationType.TRANSLATE);
        setTransformationCommand(new TranslationCommand());
    }
}
