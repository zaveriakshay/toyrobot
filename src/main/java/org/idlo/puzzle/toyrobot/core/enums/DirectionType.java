package org.idlo.puzzle.toyrobot.core.enums;


import org.idlo.puzzle.toyrobot.core.constants.AppConstants;

/**
 * @author akshay.zaveri
 * This enum will define the possible directions for the application.
 */
public enum DirectionType {

    NORTH (AppConstants.WEST, AppConstants.EAST),

    EAST (AppConstants.NORTH, AppConstants.SOUTH),

    SOUTH (AppConstants.EAST, AppConstants.WEST),

    WEST (AppConstants.SOUTH, AppConstants.NORTH);

    /**
     * Final direction when -90 rotation is executed.
     */
    private String leftDirection;

    /**
     * Final direction when -90 rotation is executed.
     */
    private String rightDirection;

    public DirectionType getLeftDirectionType(){
        return DirectionType.valueOf(getLeftDirection());
    }

    public DirectionType getRightDirectionType(){
        return DirectionType.valueOf(getRightDirection());
    }

    /**
     * Below contructor accepts the outcome -90 and 90 rotations.
     * @param leftDirection
     * @param rightDirection
     */
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
