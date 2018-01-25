package org.ideallo.puzzle.toyrobot.core.command;

import org.ideallo.puzzle.toyrobot.core.constants.AppConstants;
import org.ideallo.puzzle.toyrobot.core.object.Coordinates;
import org.ideallo.puzzle.toyrobot.core.object.Robot;
import org.ideallo.puzzle.toyrobot.core.object.TransformationException;

/**
 * @author akshay.zaveri
 */
public class PositionCommand extends BaseTransformationCommand<Robot> {

    private static final long serialVersionUID = 2493299091335596551L;

    public PositionCommand(Coordinates coordinates){
        setCoordinates(coordinates);
    }

    private Coordinates  coordinates;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public Robot preExecute(Robot instance) {
        if (!this.getCoordinates().isWithinRange(new Coordinates())) {
            throw new TransformationException(AppConstants._CONSTRAINT_BOUNDARY_1);
        }
        return instance;
    }

    @Override
    public Robot execute(Robot instance) {
        instance.setCoordinates(getCoordinates());
        return instance;
    }
}
