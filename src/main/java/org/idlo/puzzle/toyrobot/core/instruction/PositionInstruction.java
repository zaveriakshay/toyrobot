package org.idlo.puzzle.toyrobot.core.instruction;

import org.idlo.puzzle.toyrobot.core.command.PositionCommand;
import org.idlo.puzzle.toyrobot.core.enums.DirectionType;
import org.idlo.puzzle.toyrobot.core.enums.TransformationType;
import org.idlo.puzzle.toyrobot.core.vector.Coordinates;

/**
 * @author akshay.zaveri
 */
public class PositionInstruction extends BaseInstruction {

    private static final long serialVersionUID = -4651279752591398871L;

    public PositionInstruction(Coordinates coordinates, DirectionType directionType){
        setTransformationType(TransformationType.POSITION);
        setTransformationCommand(new PositionCommand(coordinates,directionType));
    }

}
