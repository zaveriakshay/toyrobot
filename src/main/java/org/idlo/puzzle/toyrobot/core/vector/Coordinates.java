package org.idlo.puzzle.toyrobot.core.vector;

import org.idlo.puzzle.toyrobot.controller.validation.InRange;
import org.idlo.puzzle.toyrobot.core.Base;
import org.idlo.puzzle.toyrobot.core.constants.AppConstants;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author akshay.zaveri
 */
public class Coordinates extends Base {

    @NotNull
    @InRange(min = 0,max = 4)
    private Integer x;

    @NotNull
    @InRange(min = 0,max = 4)
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
        return futureX <= AppConstants.TABLE_MAX_X && futureX >= AppConstants.TABLE_MIN_X && futureY <= AppConstants.TABLE_MAX_Y && futureY >= AppConstants.TABLE_MIN_Y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(x, that.x) &&
                Objects.equals(y, that.y);
    }

}
