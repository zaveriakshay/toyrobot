package org.idlo.puzzle.toyrobot.core.vector;

import org.idlo.puzzle.toyrobot.core.enums.DirectionType;

/**
 * @author akshay.zaveri
 */
public class WestTranslation extends Translation {

    public WestTranslation(){
        setDirectionType(DirectionType.WEST);
        setAdjustmentCoodinates(new Coordinates(-1,0));
    }

}
