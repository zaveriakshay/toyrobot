package org.idlo.puzzle.toyrobot.core.command;

import org.idlo.puzzle.toyrobot.core.Robot;
import org.idlo.puzzle.toyrobot.core.enums.DirectionType;
import org.idlo.puzzle.toyrobot.core.enums.ErrorType;
import org.idlo.puzzle.toyrobot.core.exception.TransformationException;
import org.idlo.puzzle.toyrobot.core.vector.*;

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
    public Robot preExecute(Robot instance) throws TransformationException {
        init(instance);

        if(!instance.getCoordinates().isWithinRange(getTranslation().getAdjustmentCoodinates())){
            throw new TransformationException(ErrorType.ERR0002);
        }
        return instance;
    }

    @Override
    public Robot execute(Robot instance) {
        instance.getCoordinates().add(getTranslation().getAdjustmentCoodinates());

        return instance;
    }

    private void init(Robot instance) {
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
    }
}
