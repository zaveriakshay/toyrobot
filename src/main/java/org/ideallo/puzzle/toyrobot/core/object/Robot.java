package org.ideallo.puzzle.toyrobot.core.object;

import org.ideallo.puzzle.toyrobot.core.Base;
import org.ideallo.puzzle.toyrobot.core.enums.DirectionType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.PostConstruct;

/**
 * @author akshay.zaveri
 */

@Component
@Scope(value = WebApplicationContext.SCOPE_APPLICATION)
public class Robot extends Base {

    private String name;

    private String model;

    private String version;

    private DirectionType directionType;

    private Coordinates coordinates;

    public Robot(){
        init();
    }

    public void init() {
        setName("Akshay Zaveri");
        setModel("T-900");
        setVersion("1.0.0.0.X");
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
