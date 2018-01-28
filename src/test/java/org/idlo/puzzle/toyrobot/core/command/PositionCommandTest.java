package org.idlo.puzzle.toyrobot.core.command;

import org.idlo.puzzle.toyrobot.core.Robot;
import org.idlo.puzzle.toyrobot.core.enums.DirectionType;
import org.idlo.puzzle.toyrobot.core.exception.TransformationException;
import org.idlo.puzzle.toyrobot.core.vector.Coordinates;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

public class PositionCommandTest {
    @Mock
    Coordinates coordinates;
    /**
     *
        Field directionType of type DirectionType - was not mocked since Mockito doesn't mock enums
     */
    @Mock
    Logger logger;
    @InjectMocks
    PositionCommand positionCommand;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = TransformationException.class)
    public void testPreExecute() throws Exception {
        positionCommand.setCoordinates(new Coordinates(8,2));
        positionCommand.setDirectionType(DirectionType.NORTH);

        Robot result = positionCommand.preExecute(new Robot());
    }

    @Test
    public void testExecute() throws Exception {
        positionCommand.setCoordinates(new Coordinates(3,2));
        positionCommand.setDirectionType(DirectionType.NORTH);

        Robot result = positionCommand.execute(new Robot());
        Assert.assertEquals(new Coordinates(3,2), result.getCoordinates());
        Assert.assertEquals(DirectionType.NORTH, result.getDirectionType());
    }

}