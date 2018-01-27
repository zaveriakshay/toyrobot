package org.idlo.puzzle.toyrobot.core.vector;

import org.idlo.puzzle.toyrobot.core.Base;
import org.idlo.puzzle.toyrobot.core.enums.DirectionType;

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
