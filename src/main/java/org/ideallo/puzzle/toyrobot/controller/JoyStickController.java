package org.ideallo.puzzle.toyrobot.controller;

import org.ideallo.puzzle.toyrobot.core.command.Instruction;
import org.ideallo.puzzle.toyrobot.core.enums.RotationType;
import org.ideallo.puzzle.toyrobot.core.object.Coordinates;
import org.ideallo.puzzle.toyrobot.core.object.Robot;
import org.ideallo.puzzle.toyrobot.service.JoyStickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author akshay.zaveri
 * This class as the name indicates, will behave as a controller for the joystick.
 * The joystick will be the service that controls the toy robot.
 */
@RestController
public class JoyStickController {

    /**
     * Add the joystick service, use composition
     */
    @Autowired
    private JoyStickService joyStick;

    @Autowired
    private Robot robot;

    @RequestMapping(path = "/place", method = RequestMethod.POST)
    public Robot place(Coordinates coordinates){
        Instruction instruction = new Instruction(coordinates);
        Robot transform = joyStick.transform(robot, instruction);
        return output();
    }

    @RequestMapping(path = "/move", method = RequestMethod.POST)
    
    public Robot move(){
        Instruction instruction = new Instruction();
        Robot transform = joyStick.transform(robot, instruction);
        return output();
    }

    @RequestMapping(path = "/left", method = RequestMethod.POST)
    
    public Robot left(){
        Instruction instruction = new Instruction(RotationType.LEFT);
        Robot transform = joyStick.transform(robot, instruction);
        return output();
    }

    @RequestMapping(path = "/right", method = RequestMethod.POST)
    
    public Robot right(){
        Instruction instruction = new Instruction(RotationType.RIGHT);
        Robot transform = joyStick.transform(robot, instruction);
        return output();
    }

    @RequestMapping(path = "/output", method = RequestMethod.GET)
    
    public Robot output(){
        return robot;
    }
}
