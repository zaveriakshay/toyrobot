package org.idlo.puzzle.toyrobot.core.command;

import org.idlo.puzzle.toyrobot.core.Robot;
import org.idlo.puzzle.toyrobot.core.enums.DirectionType;
import org.idlo.puzzle.toyrobot.core.enums.RotationType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class RotationCommandTest {
    /**
     *
        Field rotationType of type RotationType - was not mocked since Mockito doesn't mock enums
     */
    @Mock
        Logger logger;
    @InjectMocks
    RotationCommand rotationCommand;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExecute() throws Exception {
        rotationCommand.setRotationType(RotationType.LEFT);
        Robot input = new Robot();
        input.setDirectionType(DirectionType.NORTH);

        Robot result = rotationCommand.execute(input);
        Assert.assertEquals(DirectionType.WEST, result.getDirectionType());

        result = rotationCommand.execute(result);
        Assert.assertEquals(DirectionType.SOUTH, result.getDirectionType());

        result = rotationCommand.execute(result);
        Assert.assertEquals(DirectionType.EAST, result.getDirectionType());

        result = rotationCommand.execute(result);
        Assert.assertEquals(DirectionType.NORTH, result.getDirectionType());

        rotationCommand.setRotationType(RotationType.RIGHT);

        result = rotationCommand.execute(result);
        Assert.assertEquals(DirectionType.EAST, result.getDirectionType());

        result = rotationCommand.execute(result);
        Assert.assertEquals(DirectionType.SOUTH, result.getDirectionType());

        result = rotationCommand.execute(result);
        Assert.assertEquals(DirectionType.WEST, result.getDirectionType());

        result = rotationCommand.execute(result);
        Assert.assertEquals(DirectionType.NORTH, result.getDirectionType());
    }

}
