package org.ideallo.puzzle.toyrobot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.ideallo.puzzle.toyrobot.core.command.Instruction;
import org.ideallo.puzzle.toyrobot.core.enums.RotationType;
import org.ideallo.puzzle.toyrobot.core.object.Coordinates;
import org.ideallo.puzzle.toyrobot.core.object.Robot;
import org.ideallo.puzzle.toyrobot.service.JoyStickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author akshay.zaveri
 * This class as the name indicates, will behave as a controller for the joystick.
 * The joystick will be the service that controls the toy robot.
 */
@RestController
@RequestMapping("/joyStick")
@Api(value="ToyRobot", description="Available commannds on the JoyStick Controller")
public class JoyStickController {

    /**
     * Add the joystick service, use composition
     */
    @Autowired
    private JoyStickService joyStickService;

    /**
     * PLACE will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST. The origin (0,0) can be considered to be the SOUTH WEST most corner.
     * @param coordinates
     * @return
     */
    @RequestMapping(path = "/place", method = RequestMethod.POST)
    @ApiOperation(value = "PLACE will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST. The origin (0,0) can be considered to be the SOUTH WEST most corner.  ",response = Robot.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully moved the robot"),
            @ApiResponse(code = 404, message = "Exception while performing this transformation")
    }
    )
    public Robot place(@RequestBody Coordinates coordinates){
        Instruction instruction = new Instruction(coordinates);
        Robot output = joyStickService.report();
        Robot transform = joyStickService.transform(output, instruction);
        return transform;
    }


    /**
     * MOVE will move the toy robot one unit forward in the direction it is currently facing
     * @return
     */
    @RequestMapping(path = "/move", method = RequestMethod.PUT)
    @ApiOperation(value = "MOVE will move the toy robot one unit forward in the direction it is currently facing",response = Robot.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully moved the robot"),
            @ApiResponse(code = 404, message = "Exception while performing this transformation")
    }
    )
    public Robot move(){
        Instruction instruction = new Instruction();
        Robot output = joyStickService.report();
        Robot transform = joyStickService.transform(output, instruction);
        return transform;
    }

    /**
     * LEFT and RIGHT will rotate the robot 90 degrees in the speciﬁed direction without changing the position of the robot.
     */
    @RequestMapping(path = "/left", method = RequestMethod.PUT)
    @ApiOperation(value = "LEFT will rotate the robot 90 degrees in the speciﬁed direction without changing the position of the robot.",response = Robot.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully moved the robot"),
            @ApiResponse(code = 404, message = "Exception while performing this transformation")
    }
    )
    public Robot left(){
        Instruction instruction = new Instruction(RotationType.LEFT);
        Robot output = joyStickService.report();
        Robot transform = joyStickService.transform(output, instruction);
        return transform;
    }

    /**
     * LEFT and RIGHT will rotate the robot 90 degrees in the speciﬁed direction without changing the position of the robot.
     */
    @RequestMapping(path = "/right", method = RequestMethod.PUT)
    @ApiOperation(value = "RIGHT will rotate the robot 90 degrees in the speciﬁed direction without changing the position of the robot.",response = Robot.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully moved the robot"),
            @ApiResponse(code = 404, message = "Exception while performing this transformation")
    }
    )
    public Robot right(){
        Instruction instruction = new Instruction(RotationType.RIGHT);
        Robot output = joyStickService.report();
        Robot transform = joyStickService.transform(output, instruction);
        return transform;
    }

    /**
     * REPORT will announce the X,Y and F of the robot.
     * @return
     */
    @RequestMapping(path = "/report", method = RequestMethod.GET)
    public Robot report(){
        return joyStickService.report();
    }


    @PostConstruct
    public void postInit(){
        System.out.println("post Init for"+this.getClass().getSimpleName());
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("pre Destroy for"+this.getClass().getSimpleName());
    }
}
