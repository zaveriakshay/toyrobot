package org.ideallo.puzzle.toyrobot.core.command;

import org.ideallo.puzzle.toyrobot.core.Base;
import org.ideallo.puzzle.toyrobot.core.object.*;

import static org.ideallo.puzzle.toyrobot.core.enums.DirectionType.NORTH;

/**
 * @author akshay.zaveri
 */
public class TranslationCommand extends BaseTransformationCommand<Robot> {


    private static final long serialVersionUID = -3235138479336955818L;

    private Translation translation;

    public Translation getTranslation() {
        return translation;
    }

    public void setTranslation(Translation translation) {
        this.translation = translation;
    }

    @Override
    public Robot preExecute(Robot instance) {
        if(!instance.getCoordinates().isWithinRange(getTranslation().getAdjustmentCoodinates())){
            throw new TransformationException();
        }
        return instance;
    }

    @Override
    public Robot execute(Robot instance) {
        switch (instance.getDirectionType()) {
            case NORTH:
                setTranslation(new NorthTranslation());
                break;
            case EAST:
                setTranslation(new EastTranslation());
                break;
            case SOUTH:
                setTranslation(new SouthTranslation());
                break;
            case WEST:
                setTranslation(new WestTranslation());
                break;
        }

        instance.getCoordinates().add(getTranslation().getAdjustmentCoodinates());

        return instance;
    }
}
