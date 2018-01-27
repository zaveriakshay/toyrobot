package org.idlo.puzzle.toyrobot.core.vector;

import org.idlo.puzzle.toyrobot.core.enums.DirectionType;

/**
 * @author akshay.zaveri
 */
public class SouthTranslation extends Translation {

    public SouthTranslation(){
        setDirectionType(DirectionType.SOUTH);
        setAdjustmentCoodinates(new Coordinates(0,-1));
    }
}
