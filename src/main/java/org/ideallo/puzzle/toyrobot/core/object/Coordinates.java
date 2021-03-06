package org.ideallo.puzzle.toyrobot.core.object;

import org.ideallo.puzzle.toyrobot.core.Base;

import static org.ideallo.puzzle.toyrobot.core.constants.AppConstants.*;

/**
 * @author akshay.zaveri
 */
public class Coordinates extends Base {

    private Integer x;

    private Integer y;

    public Coordinates(){
        setX(0);
        setY(0);
    }

    public Coordinates(Integer x,Integer y){
        setX(x);
        setY(y);
    }


    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void add(Coordinates coordinates){
        this.setX(this.getX() + coordinates.getX());
        this.setY(this.getY() + coordinates.getY());
    }

    public Boolean isWithinRange(Coordinates coordinates){
        int futureX = this.getX() + coordinates.getX();
        int futureY = this.getY() + coordinates.getY();
        return futureX <= _TABLE_MAX_X && futureX >= _TABLE_MIN_X && futureY <= _TABLE_MAX_Y && futureY >= _TABLE_MIN_Y;
    }

}
