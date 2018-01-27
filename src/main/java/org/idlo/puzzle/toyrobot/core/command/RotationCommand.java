package org.idlo.puzzle.toyrobot.core.command;

import org.idlo.puzzle.toyrobot.core.Robot;
import org.idlo.puzzle.toyrobot.core.enums.RotationType;
import org.idlo.puzzle.toyrobot.core.exception.TransformationException;

/**
 * @author akshay.zaveri
 */
public class RotationCommand extends BaseTransformationCommand<Robot> {


    private static final long serialVersionUID = 5256262707439829019L;

    private RotationType rotationType;

    public RotationCommand (){

    }

    public RotationCommand(RotationType rotationType){
        setRotationType(rotationType);
    }

    public RotationType getRotationType() {
        return rotationType;
    }

    public void setRotationType(RotationType rotationType) {
        this.rotationType = rotationType;
    }

    @Override
    public Robot execute(Robot instance) throws TransformationException {
        super.execute(instance);
        if(getRotationType() == RotationType.LEFT){
            instance.setDirectionType(instance.getDirectionType().getLeftDirectionType());
        }else if(getRotationType() == RotationType.RIGHT){
            instance.setDirectionType(instance.getDirectionType().getRightDirectionType());
        }
        return instance;
    }
}
