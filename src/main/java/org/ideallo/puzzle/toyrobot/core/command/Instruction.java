package org.ideallo.puzzle.toyrobot.core.command;

import org.ideallo.puzzle.toyrobot.core.Base;
import org.ideallo.puzzle.toyrobot.core.enums.RotationType;
import org.ideallo.puzzle.toyrobot.core.enums.TransformationType;
import org.ideallo.puzzle.toyrobot.core.object.Coordinates;

/**
 * @author akshay.zaveri
 */
public class Instruction extends Base {

    private static final long serialVersionUID = -4651279752591398871L;

    private TransformationType transformationType;

    private RotationType rotationType;

    private Coordinates coordinates;

    private TransformationCommand transformationCommand;

    public Instruction(RotationType rotationType){
        setTransformationType(TransformationType.ROTATE);
        setRotationType(rotationType);
        setTransformationCommand(new RotationCommand());
    }

    public Instruction(Coordinates coordinates){
        setTransformationType(TransformationType.POSITION);
        setCoordinates(coordinates);
        setTransformationCommand(new PositionCommand());
    }

    public Instruction(){
        setTransformationType(TransformationType.TRANSLATE);
        setTransformationCommand(new TranslationCommand());
    }


    public TransformationType getTransformationType() {
        return transformationType;
    }

    public void setTransformationType(TransformationType transformationType) {
        this.transformationType = transformationType;
    }

    public RotationType getRotationType() {
        return rotationType;
    }

    public void setRotationType(RotationType rotationType) {
        this.rotationType = rotationType;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public TransformationCommand getTransformationCommand() {
        return transformationCommand;
    }

    public void setTransformationCommand(TransformationCommand transformationCommand) {
        this.transformationCommand = transformationCommand;
    }
}
