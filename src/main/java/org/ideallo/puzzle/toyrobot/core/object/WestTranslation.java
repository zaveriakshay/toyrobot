package org.ideallo.puzzle.toyrobot.core.object;

import org.ideallo.puzzle.toyrobot.core.enums.DirectionType;

/**
 * @author akshay.zaveri
 */
public class WestTranslation extends Translation {

    public WestTranslation(){
        setDirectionType(DirectionType.WEST);
        setAdjustmentCoodinates(new Coordinates(-1,0));
    }

}
