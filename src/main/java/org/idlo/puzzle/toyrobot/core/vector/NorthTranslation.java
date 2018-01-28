package org.idlo.puzzle.toyrobot.core.vector;

import org.idlo.puzzle.toyrobot.core.enums.DirectionType;

/**
 * @author akshay.zaveri
 * This class represent the translation when the robot faces NORTH.
 * The adjustment coordinates are set wrt to any movements that could occur facing NORTH.
 */
public class NorthTranslation extends Translation {

    private static final long serialVersionUID = -7081616997409182121L;

    public NorthTranslation(){
        setDirectionType(DirectionType.NORTH);
        setAdjustmentCoodinates(new Coordinates(0,1));
    }
}
