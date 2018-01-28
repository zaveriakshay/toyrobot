package org.idlo.puzzle.toyrobot.core.vector;

import org.idlo.puzzle.toyrobot.core.enums.DirectionType;

/**
 * @author akshay.zaveri
 * This class represent the translation when the robot faces EAST.
 * The adjustment coordinates are set wrt to any movements that could occur facing EAST.
 */
public class EastTranslation extends Translation {

    private static final long serialVersionUID = 9181063324587802823L;

    public EastTranslation(){
        setDirectionType(DirectionType.EAST);
        setAdjustmentCoodinates(new Coordinates(+1,0));
    }
}
