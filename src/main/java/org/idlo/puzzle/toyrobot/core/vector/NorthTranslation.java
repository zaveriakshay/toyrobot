package org.idlo.puzzle.toyrobot.core.vector;

import org.idlo.puzzle.toyrobot.core.enums.DirectionType;

/**
 * @author akshay.zaveri
 */
public class NorthTranslation extends Translation {

    public NorthTranslation(){
        setDirectionType(DirectionType.NORTH);
        setAdjustmentCoodinates(new Coordinates(0,1));
    }
}
