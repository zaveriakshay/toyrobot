package org.idlo.puzzle.toyrobot.core.command;

import org.idlo.puzzle.toyrobot.core.Robot;
import org.idlo.puzzle.toyrobot.core.enums.DirectionType;
import org.idlo.puzzle.toyrobot.core.enums.ErrorType;
import org.idlo.puzzle.toyrobot.core.exception.TransformationException;
import org.idlo.puzzle.toyrobot.core.vector.Coordinates;

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
    public Robot preExecute(Robot instance) throws TransformationException {
        super.preExecute(instance);
        if (!this.getCoordinates().isWithinRange(new Coordinates())) {
            throw new TransformationException(ErrorType.ERR0001);
        }
        return instance;
    }

    @Override
    public Robot execute(Robot instance) throws TransformationException {
        super.execute(instance);
        instance.setCoordinates(getCoordinates());
        instance.setDirectionType(getDirectionType());
        return instance;
    }
}
