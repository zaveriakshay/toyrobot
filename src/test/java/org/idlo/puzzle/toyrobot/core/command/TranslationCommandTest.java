package org.idlo.puzzle.toyrobot.core.command;

import org.idlo.puzzle.toyrobot.core.Robot;
import org.idlo.puzzle.toyrobot.core.enums.DirectionType;
import org.idlo.puzzle.toyrobot.core.exception.TransformationException;
import org.idlo.puzzle.toyrobot.core.vector.Coordinates;
import org.idlo.puzzle.toyrobot.core.vector.Translation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
public class TranslationCommandTest {
    @Mock
    Translation translation;

    @Mock
    Logger logger;

    @InjectMocks
    TranslationCommand translationCommand;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExecute() throws Exception {
        when(translation.getAdjustmentCoodinates()).thenReturn(new Coordinates(Integer.valueOf(0), Integer.valueOf(1)));

        Robot input = new Robot();
        input.setDirectionType(DirectionType.NORTH);
        input.setCoordinates(new Coordinates(0,0));

        Robot result = translationCommand.execute(input);
        Assert.assertEquals(result.getCoordinates(), new Coordinates(0,1));

        result = translationCommand.execute(input);
        Assert.assertEquals(result.getCoordinates(), new Coordinates(0,2));

        result = translationCommand.execute(input);
        Assert.assertEquals(result.getCoordinates(), new Coordinates(0,3));

        result = translationCommand.execute(input);
        Assert.assertEquals(result.getCoordinates(), new Coordinates(0,4));

    }


    @Test(expected = TransformationException.class)
    public void testPreExecuteNorth() throws Exception {
        when(translation.getAdjustmentCoodinates()).thenReturn(new Coordinates(Integer.valueOf(0), Integer.valueOf(1)));

        Robot input = new Robot();
        input.setDirectionType(DirectionType.NORTH);
        input.setCoordinates(new Coordinates(0,4));
        Robot result = translationCommand.preExecute(input);
    }

    @Test(expected = TransformationException.class)
    public void testPreExecuteWest() throws Exception {
        when(translation.getAdjustmentCoodinates()).thenReturn(new Coordinates(Integer.valueOf(1), Integer.valueOf(0)));

        Robot input = new Robot();
        input.setDirectionType(DirectionType.EAST);
        input.setCoordinates(new Coordinates(4,0));
        Robot result = translationCommand.preExecute(input);

    }
}

