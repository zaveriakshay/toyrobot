package org.ideallo.puzzle.toyrobot.core.object;

import org.ideallo.puzzle.toyrobot.core.Base;
import org.ideallo.puzzle.toyrobot.core.enums.DirectionType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 * @author akshay.zaveri
 */
@Component
@ApplicationScope
public class Robot extends Base {

    private String name;

    private String model;

    private String version;

    private DirectionType directionType;

    private Coordinates coordinates;

    public Robot(){
        init();
    }

    private void init() {
        setDirectionType(DirectionType.NORTH);
        setCoordinates(new Coordinates());
    }

    public Robot (String name, String model, String version, DirectionType directionType, Coordinates coordinates){
        setName(name);
        setModel(model);
        setVersion(version);
        setDirectionType(directionType);
        setCoordinates(coordinates);
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
        return directionType;
    }

    public void setDirectionType(DirectionType directionType) {
        this.directionType = directionType;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

}
