package org.ideallo.puzzle.toyrobot.core.enums;


import static org.ideallo.puzzle.toyrobot.core.constants.AppConstants.*;

/**
 * @author akshay.zaveri
 */
public enum DirectionType {

    NORTH (_WEST,_EAST),

    EAST (_NORTH,_SOUTH),

    SOUTH (_EAST,_WEST),

    WEST (_SOUTH,_NORTH);

    private String leftDirection;

    private String rightDirection;

    public DirectionType getLeftDirectionType(){
        return DirectionType.valueOf(getLeftDirection());
    }

    public DirectionType getRightDirectionType(){
        return DirectionType.valueOf(getRightDirection());
    }

    private DirectionType(){

    }

    private DirectionType(String leftDirection, String rightDirection){
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
