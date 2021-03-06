package org.ideallo.puzzle.toyrobot.core.command;

import org.ideallo.puzzle.toyrobot.core.Base;
import org.ideallo.puzzle.toyrobot.core.enums.RotationType;
import org.ideallo.puzzle.toyrobot.core.object.Robot;

/**
 * @author akshay.zaveri
 */
public class RotationCommand extends BaseTransformationCommand<Robot> {


    private static final long serialVersionUID = 5256262707439829019L;

    private RotationType rotationType;

    public RotationType getRotationType() {
        return rotationType;
    }

    public void setRotationType(RotationType rotationType) {
        this.rotationType = rotationType;
    }

    @Override
    public Robot execute(Robot instance) {
        if(getRotationType() == RotationType.LEFT){
            instance.setDirectionType(instance.getDirectionType().getLeftDirectionType());
        }else if(getRotationType() == RotationType.RIGHT){
            instance.setDirectionType(instance.getDirectionType().getRightDirectionType());
        }
        return instance;
    }
}
