package org.ideallo.puzzle.toyrobot.core.command;

import org.ideallo.puzzle.toyrobot.core.constants.AppConstants;
import org.ideallo.puzzle.toyrobot.core.enums.DirectionType;
import org.ideallo.puzzle.toyrobot.core.vector.Coordinates;
import org.ideallo.puzzle.toyrobot.core.Robot;
import org.ideallo.puzzle.toyrobot.core.vector.TransformationException;

/**
 * @author akshay.zaveri
 */
public class PositionCommand extends BaseTransformationCommand<Robot> {

    private static final long serialVersionUID = 2493299091335596551L;

    public PositionCommand(Coordinates coordinates){
        setCoordinates(coordinates);
    }

    public PositionCommand(Coordinates coordinates,DirectionType directionType){
        setCoordinates(coordinates);
        setDirectionType(directionType);
    }

    private Coordinates  coordinates;

    private DirectionType directionType;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public DirectionType getDirectionType() {
        return directionType;
    }

    public void setDirectionType(DirectionType directionType) {
        this.directionType = directionType;
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
        instance.setDirectionType(getDirectionType());
        return instance;
    }
}
