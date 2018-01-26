package org.ideallo.puzzle.toyrobot.core.vector;

import org.ideallo.puzzle.toyrobot.core.enums.DirectionType;

/**
 * @author akshay.zaveri
 */
public class EastTranslation extends Translation {

    public EastTranslation(){
        setDirectionType(DirectionType.EAST);
        setAdjustmentCoodinates(new Coordinates(+1,0));
    }
}
