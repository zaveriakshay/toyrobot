package org.ideallo.puzzle.toyrobot.core.vector;

import org.ideallo.puzzle.toyrobot.controller.validation.InRange;
import org.ideallo.puzzle.toyrobot.core.Base;
import org.ideallo.puzzle.toyrobot.core.enums.DirectionType;
import org.springframework.beans.factory.annotation.Required;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author akshay.zaveri
 */

public class Orientation extends Base {

    @NotNull
    @Valid
    private DirectionType directionType;

    @NotNull
    @Valid
    private Coordinates coordinates;

    public DirectionType getDirectionType() {
        return directionType;
    }

    public void setDirectionType(DirectionType directionType) {
        this.directionType = directionType;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

}
