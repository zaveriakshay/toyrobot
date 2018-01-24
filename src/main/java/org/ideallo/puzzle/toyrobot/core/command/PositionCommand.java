package org.ideallo.puzzle.toyrobot.core.command;

import org.ideallo.puzzle.toyrobot.core.Base;
import org.ideallo.puzzle.toyrobot.core.object.Coordinates;
import org.ideallo.puzzle.toyrobot.core.object.Robot;

/**
 * @author akshay.zaveri
 */
public class PositionCommand extends BaseTransformationCommand<Robot> {

    private static final long serialVersionUID = 2493299091335596551L;

    private Coordinates  coordinates;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public Robot execute(Robot instance) {
        instance.setCoordinates(getCoordinates());
        return instance;
    }
}
