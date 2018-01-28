package org.idlo.puzzle.toyrobot.core.vector;

import org.idlo.puzzle.toyrobot.core.Base;
import org.idlo.puzzle.toyrobot.core.enums.DirectionType;

/**
 * @author akshay.zaveri
 * This class represents all kinds of translations possible, this can vary depending
 * on the direction the robot is facing.
 */
public abstract class Translation extends Base {

    private DirectionType directionType;

    private Coordinates adjustmentCoodinates;

    public DirectionType getDirectionType() {
        return directionType;
    }

    public void setDirectionType(DirectionType directionType) {
        this.directionType = directionType;
    }

    public Coordinates getAdjustmentCoodinates() {
        return adjustmentCoodinates;
    }

    public void setAdjustmentCoodinates(Coordinates adjustmentCoodinates) {
        this.adjustmentCoodinates = adjustmentCoodinates;
    }
}
