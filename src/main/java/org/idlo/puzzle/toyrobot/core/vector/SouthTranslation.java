package org.idlo.puzzle.toyrobot.core.vector;

import org.idlo.puzzle.toyrobot.core.enums.DirectionType;

/**
 * @author akshay.zaveri
 * This class represent the translation when the robot faces SOUTH.
 * The adjustment coordinates are set wrt to any movements that could occur facing SOUTH.
 */
public class SouthTranslation extends Translation {

    private static final long serialVersionUID = 4239880612874557434L;

    public SouthTranslation(){
        setDirectionType(DirectionType.SOUTH);
        setAdjustmentCoodinates(new Coordinates(0,-1));
    }
}
