package org.idlo.puzzle.toyrobot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.idlo.puzzle.toyrobot.core.Robot;
import org.idlo.puzzle.toyrobot.core.enums.ErrorType;
import org.idlo.puzzle.toyrobot.core.enums.RotationType;
import org.idlo.puzzle.toyrobot.core.exception.BindingException;
import org.idlo.puzzle.toyrobot.core.exception.TransformationException;
import org.idlo.puzzle.toyrobot.core.instruction.BaseInstruction;
import org.idlo.puzzle.toyrobot.core.instruction.PositionInstruction;
import org.idlo.puzzle.toyrobot.core.instruction.RotationInstruction;
import org.idlo.puzzle.toyrobot.core.instruction.TranslationInstruction;
import org.idlo.puzzle.toyrobot.core.vector.Orientation;
import org.idlo.puzzle.toyrobot.service.JoyStickService;
import org.idlo.puzzle.toyrobot.core.constants.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.validation.Valid;
import java.util.List;

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
     * @param orientation
     * @return
     */
    @RequestMapping(path = "/place", method = RequestMethod.POST)
    @ApiOperation(value = "PLACE will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST. The origin (0,0) can be considered to be the SOUTH WEST most corner.  ",response = Robot.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully moved the robot"),
            @ApiResponse(code = 404, message = "Exception while performing this transformation")
    }
    )
    public Robot place(@Valid @RequestBody Orientation orientation, BindingResult bindingResult) throws TransformationException {
        handleBindingResult(bindingResult);
        BaseInstruction baseInstruction = new PositionInstruction(orientation.getCoordinates(),orientation.getDirectionType());
        Robot output = joyStickService.report();
        return joyStickService.transform(output, baseInstruction);
    }

    private void handleBindingResult(BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            String errorMessage = null;
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fieldError : fieldErrors){
                errorMessage = "Field<<"+fieldError.getField()+">>,Error<<"+fieldError.getDefaultMessage()+">>,Rejected Value<<"+fieldError.getRejectedValue()+">>";
            }
            throw new BindingException(errorMessage,bindingResult, ErrorType.ERR0004);
        }
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
    public Robot move()throws TransformationException{
        BaseInstruction baseInstruction = new TranslationInstruction();
        Robot output = joyStickService.report();
        return joyStickService.transform(output, baseInstruction);
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
    public Robot left()throws TransformationException{
        BaseInstruction baseInstruction = new RotationInstruction(RotationType.LEFT);
        Robot output = joyStickService.report();
        return joyStickService.transform(output, baseInstruction);
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
    public Robot right()throws TransformationException{
        BaseInstruction baseInstruction = new RotationInstruction(RotationType.RIGHT);
        Robot output = joyStickService.report();
        return joyStickService.transform(output, baseInstruction);
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
