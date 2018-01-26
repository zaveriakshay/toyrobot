package org.ideallo.puzzle.toyrobot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import org.ideallo.puzzle.toyrobot.core.Robot;
import org.ideallo.puzzle.toyrobot.core.config.Bootstrap;
import org.ideallo.puzzle.toyrobot.core.enums.DirectionType;
import org.ideallo.puzzle.toyrobot.core.vector.Coordinates;
import org.ideallo.puzzle.toyrobot.core.vector.Orientation;
import org.ideallo.puzzle.toyrobot.service.JoyStickService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = Bootstrap.class)
@AutoConfigureMockMvc
public class JoyStickControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

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

    @Test
    public void testPlaceAbsentCoordinates() throws Exception {
        Orientation orientation  =  new Orientation();
        orientation.setDirectionType(DirectionType.EAST);

        ResultActions perform = mvc.perform(post("/joyStick/place", orientation).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(orientation)));
        perform.andExpect(status().isBadRequest());
        MvcResult mvcResult = perform.andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        System.out.println(contentAsString);
    }

    @Test
    public void testMove() throws Exception {
        mvc.perform(put("/joyStick/move").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
                .andExpect(jsonPath("$.coordinates.x", is(0)))
                .andExpect(jsonPath("$.coordinates.y", is(1)));
    }

    @Test
    public void testLeft() throws Exception {
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

    @Test
    public void testRight() throws Exception {
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

    @Test
    public void testReport() throws Exception {
        mvc.perform(get("/joyStick/report").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is("Akshay Zaveri")))
                .andExpect(jsonPath("$.directionType", is(DirectionType.NORTH.name())))
                .andExpect(jsonPath("$.coordinates.x", is(0)))
                .andExpect(jsonPath("$.coordinates.y", is(0)));
    }

}