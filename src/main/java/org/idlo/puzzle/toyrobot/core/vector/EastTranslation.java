package org.idlo.puzzle.toyrobot.core.vector;

import org.idlo.puzzle.toyrobot.core.enums.DirectionType;

/**
 * @author akshay.zaveri
 */
public class EastTranslation extends Translation {

    public EastTranslation(){
        setDirectionType(DirectionType.EAST);
        setAdjustmentCoodinates(new Coordinates(+1,0));
    }
}
