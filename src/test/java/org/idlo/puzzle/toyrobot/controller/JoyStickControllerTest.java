package org.idlo.puzzle.toyrobot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.idlo.puzzle.toyrobot.core.config.Bootstrap;
import org.idlo.puzzle.toyrobot.core.enums.DirectionType;
import org.idlo.puzzle.toyrobot.core.enums.ErrorType;
import org.idlo.puzzle.toyrobot.core.vector.Coordinates;
import org.idlo.puzzle.toyrobot.core.vector.Orientation;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author akshay.zaveri
 * This is the test class for {@link JoyStickController}, it is the integration test class.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = Bootstrap.class)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JoyStickControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    /**
     * This is the method to test the place instruction
     * @throws Exception
     */
    @Test
    public void testPlace() throws Exception {
        Orientation orientation  =  new Orientation();
        orientation.setCoordinates(new Coordinates(2,3));
        orientation.setDirectionType(DirectionType.EAST);

        mvc.perform(post("/joyStick/place",orientation).accept(MediaType.APPLICATION_JSON) .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(orientation)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.directionType", is(DirectionType.EAST.name())))
                .andExpect(jsonPath("$.coordinates.x", is(2)))
                .andExpect(jsonPath("$.coordinates.y", is(3)));
    }

    /**
     * This is the method to test the place instruction, when coordinates are absent.
     * @throws Exception
     */
    @Test
    public void testPlaceAbsentCoordinates() throws Exception {
        Orientation orientation  =  new Orientation();
        orientation.setDirectionType(DirectionType.EAST);

        ResultActions perform = mvc.perform(post("/joyStick/place", orientation).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(orientation)));
        perform.andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode", is(ErrorType.ERR0004.name())));
    }

    /**
     * This is the method to test the move instruction
     * @throws Exception
     */
    @Test
    public void testMove() throws Exception {
        resetToNorth();

        mvc.perform(put("/joyStick/move").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
                .andExpect(jsonPath("$.coordinates.x", is(0)))
                .andExpect(jsonPath("$.coordinates.y", is(1)));
    }

    /**
     * This is the method to test the left instruction
     * @throws Exception
     */
    @Test
    public void testLeft() throws Exception {
        resetToNorth();

        mvc.perform(put("/joyStick/left").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.directionType", is(DirectionType.WEST.name())))
                .andExpect(jsonPath("$.coordinates.x", is(0)))
                .andExpect(jsonPath("$.coordinates.y", is(0)));

        mvc.perform(put("/joyStick/left").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.directionType", is(DirectionType.SOUTH.name())))
                .andExpect(jsonPath("$.coordinates.x", is(0)))
                .andExpect(jsonPath("$.coordinates.y", is(0)));

        mvc.perform(put("/joyStick/left").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.directionType", is(DirectionType.EAST.name())))
                .andExpect(jsonPath("$.coordinates.x", is(0)))
                .andExpect(jsonPath("$.coordinates.y", is(0)));

        mvc.perform(put("/joyStick/left").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.directionType", is(DirectionType.NORTH.name())))
                .andExpect(jsonPath("$.coordinates.x", is(0)))
                .andExpect(jsonPath("$.coordinates.y", is(0)));
    }

    /**
     * This is the method to reset Robot to north.
     * @throws Exception
     */
    private void resetToNorth() throws Exception {
        Orientation orientation  =  new Orientation();
        orientation.setCoordinates(new Coordinates(0,0));
        orientation.setDirectionType(DirectionType.NORTH);

        mvc.perform(post("/joyStick/place",orientation).accept(MediaType.APPLICATION_JSON) .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(orientation)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.directionType", is(DirectionType.NORTH.name())))
                .andExpect(jsonPath("$.coordinates.x", is(0)))
                .andExpect(jsonPath("$.coordinates.y", is(0)));
    }

    /**
     * This is the method to test the right instruction
     * @throws Exception
     */
    @Test
    public void testRight() throws Exception {
        resetToNorth();

        mvc.perform(put("/joyStick/right").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.directionType", is(DirectionType.EAST.name())))
                .andExpect(jsonPath("$.coordinates.x", is(0)))
                .andExpect(jsonPath("$.coordinates.y", is(0)));

        mvc.perform(put("/joyStick/right").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.directionType", is(DirectionType.SOUTH.name())))
                .andExpect(jsonPath("$.coordinates.x", is(0)))
                .andExpect(jsonPath("$.coordinates.y", is(0)));

        mvc.perform(put("/joyStick/right").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.directionType", is(DirectionType.WEST.name())))
                .andExpect(jsonPath("$.coordinates.x", is(0)))
                .andExpect(jsonPath("$.coordinates.y", is(0)));

        mvc.perform(put("/joyStick/right").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.directionType", is(DirectionType.NORTH.name())))
                .andExpect(jsonPath("$.coordinates.x", is(0)))
                .andExpect(jsonPath("$.coordinates.y", is(0)));
    }

    /**
     * This is the method to test the report instruction
     * @throws Exception
     */
    @Test
    public void testReport() throws Exception {
        resetToNorth();

        mvc.perform(put("/joyStick/right").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.directionType", is(DirectionType.EAST.name())))
                .andExpect(jsonPath("$.coordinates.x", is(0)))
                .andExpect(jsonPath("$.coordinates.y", is(0)));


        mvc.perform(put("/joyStick/move").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.directionType", is(DirectionType.EAST.name())))
                .andExpect(jsonPath("$.coordinates.x", is(1)))
                .andExpect(jsonPath("$.coordinates.y", is(0)));


        mvc.perform(put("/joyStick/move").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.directionType", is(DirectionType.EAST.name())))
                .andExpect(jsonPath("$.coordinates.x", is(2)))
                .andExpect(jsonPath("$.coordinates.y", is(0)));


        mvc.perform(put("/joyStick/move").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.directionType", is(DirectionType.EAST.name())))
                .andExpect(jsonPath("$.coordinates.x", is(3)))
                .andExpect(jsonPath("$.coordinates.y", is(0)));

        mvc.perform(put("/joyStick/move").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.directionType", is(DirectionType.EAST.name())))
                .andExpect(jsonPath("$.coordinates.x", is(4)))
                .andExpect(jsonPath("$.coordinates.y", is(0)));

        mvc.perform(get("/joyStick/report").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is("Akshay Zaveri")))
                .andExpect(jsonPath("$.directionType", is(DirectionType.EAST.name())))
                .andExpect(jsonPath("$.coordinates.x", is(4)))
                .andExpect(jsonPath("$.coordinates.y", is(0)));

        mvc.perform(put("/joyStick/move").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode", is(ErrorType.ERR0002.name())));

        mvc.perform(get("/joyStick/report").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is("Akshay Zaveri")))
                .andExpect(jsonPath("$.directionType", is(DirectionType.EAST.name())))
                .andExpect(jsonPath("$.coordinates.x", is(4)))
                .andExpect(jsonPath("$.coordinates.y", is(0)));
    }

    /**
     * This is the method to test the move instruction without placing the robot
     * @throws Exception
     */
    @Test
    public void test1WithoutPlacement() throws Exception {
        mvc.perform(put("/joyStick/move").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode", is(ErrorType.ERR0005.name())));
    }

    /**
     * This is the method to test the move instruction without placing the robot
     * @throws Exception
     */
    @Test
    public void test2WithoutPlacement() throws Exception {
        mvc.perform(put("/joyStick/left").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode", is(ErrorType.ERR0005.name())));
    }


    /**
     * This is the method to test the move instruction without placing the robot
     * @throws Exception
     */
    @Test
    public void test3WithoutPlacement() throws Exception {
        mvc.perform(put("/joyStick/right").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode", is(ErrorType.ERR0005.name())));
    }


    /**
     * This is the method to test the move instruction without placing the robot
     * @throws Exception
     */
    @Test
    public void test4WithoutPlacement() throws Exception {
        mvc.perform(get("/joyStick/report").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode", is(ErrorType.ERR0005.name())));
    }
}