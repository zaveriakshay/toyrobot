package org.idlo.puzzle.toyrobot.core.vector;

import org.idlo.puzzle.toyrobot.core.enums.DirectionType;

/**
 * @author akshay.zaveri
 * This class represent the translation when the robot faces WEST.
 * The adjustment coordinates are set wrt to any movements that could occur facing WEST.
 */
public class WestTranslation extends Translation {

    private static final long serialVersionUID = -709700158974164704L;

    public WestTranslation(){
        setDirectionType(DirectionType.WEST);
        setAdjustmentCoodinates(new Coordinates(-1,0));
    }

}
