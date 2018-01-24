package org.ideallo.puzzle.toyrobot.core.object;

import org.ideallo.puzzle.toyrobot.core.enums.DirectionType;

/**
 * @author akshay.zaveri
 */
public class SouthTranslation extends Translation {

    public SouthTranslation(){
        setDirectionType(DirectionType.SOUTH);
        setAdjustmentCoodinates(new Coordinates(0,-1));
    }
}
