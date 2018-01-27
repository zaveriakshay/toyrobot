package org.idlo.puzzle.toyrobot.core.enums;


import org.idlo.puzzle.toyrobot.core.constants.AppConstants;

/**
 * @author akshay.zaveri
 */
public enum DirectionType {

    NORTH (AppConstants.WEST, AppConstants.EAST),

    EAST (AppConstants.NORTH, AppConstants.SOUTH),

    SOUTH (AppConstants.EAST, AppConstants.WEST),

    WEST (AppConstants.SOUTH, AppConstants.NORTH);

    private String leftDirection;

    private String rightDirection;

    public DirectionType getLeftDirectionType(){
        return DirectionType.valueOf(getLeftDirection());
    }

    public DirectionType getRightDirectionType(){
        return DirectionType.valueOf(getRightDirection());
    }

    DirectionType(String leftDirection, String rightDirection){
        setLeftDirection(leftDirection);
        setRightDirection(rightDirection);
    }

    public String getLeftDirection() {
        return leftDirection;
    }

    public void setLeftDirection(String leftDirection) {
        this.leftDirection = leftDirection;
    }

    public String getRightDirection() {
        return rightDirection;
    }

    public void setRightDirection(String rightDirection) {
        this.rightDirection = rightDirection;
    }
}
