package org.idlo.puzzle.toyrobot.core;

import org.idlo.puzzle.toyrobot.core.enums.DirectionType;
import org.idlo.puzzle.toyrobot.core.vector.Coordinates;
import org.idlo.puzzle.toyrobot.core.vector.Orientation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author akshay.zaveri
 * This is Robot class, its scope is applcation level.
 * It has a name, model and version, the orientation is the most important, contains direction and coordinates.
 */

@Component
@Scope(value = WebApplicationContext.SCOPE_APPLICATION)
public class Robot extends Base {

    private String name;

    private String model;

    private String version;

    private Orientation orientation;

    public Robot(){
        init();
    }

    public void init() {
        setName("Akshay Zaveri");
        setModel("T-900");
        setVersion("1.0.0.0.X");
        setOrientation(new Orientation());
        setDirectionType(DirectionType.NORTH);
        setCoordinates(new Coordinates());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public DirectionType getDirectionType() {
        return this.getOrientation().getDirectionType();
    }

    public void setDirectionType(DirectionType directionType) {
        this.getOrientation().setDirectionType(directionType);
    }

    public Coordinates getCoordinates() {
        return this.getOrientation().getCoordinates();
    }

    public void setCoordinates(Coordinates coordinates) {
        this.getOrientation().setCoordinates(coordinates);
    }

    private Orientation getOrientation() {
        return orientation;
    }

    private void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
