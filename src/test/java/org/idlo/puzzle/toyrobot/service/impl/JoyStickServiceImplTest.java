package org.idlo.puzzle.toyrobot.service.impl;

import org.idlo.puzzle.toyrobot.core.Robot;
import org.idlo.puzzle.toyrobot.core.enums.DirectionType;
import org.idlo.puzzle.toyrobot.core.enums.RotationType;
import org.idlo.puzzle.toyrobot.core.exception.RobotMissingException;
import org.idlo.puzzle.toyrobot.core.exception.TransformationException;
import org.idlo.puzzle.toyrobot.core.instruction.PositionInstruction;
import org.idlo.puzzle.toyrobot.core.instruction.RotationInstruction;
import org.idlo.puzzle.toyrobot.core.instruction.TranslationInstruction;
import org.idlo.puzzle.toyrobot.core.vector.Coordinates;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import static org.mockito.Mockito.*;

/**
 * This is the test class for {@link JoyStickServiceImpl}
 */
public class JoyStickServiceImplTest {
    @Mock
    Robot robot;
    @Mock
    Logger logger;
    @InjectMocks
    JoyStickServiceImpl joyStickServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * This method will test if the rotate instruction works.
     * @throws Exception
     */
    @Test
    public void testRotateTransform() throws Exception {
        Robot input = new Robot();
        input.setCoordinates(new Coordinates(2,3));
        input.setDirectionType(DirectionType.NORTH);

        Robot result = joyStickServiceImpl.transform(input, new RotationInstruction(RotationType.LEFT));
        Assert.assertEquals(DirectionType.WEST, result.getDirectionType());
    }

    /**
     * This method tests if the Position instruction works.
     * @throws Exception
     */
    @Test
    public void testPositionTransform() throws Exception {
        Robot input = new Robot();

        Robot result = joyStickServiceImpl.transform(input, new PositionInstruction(new Coordinates(2,3),DirectionType.NORTH));
        Assert.assertEquals(DirectionType.NORTH, result.getDirectionType());
        Assert.assertEquals(new Coordinates(2,3), result.getCoordinates());
    }

    /**
     * This is the test method to validate if the position instruction doesnot palce the robot outside the table.
     * @throws Exception
     */
    @Test(expected = TransformationException.class)
    public void testPositionTransformFailure() throws Exception {
        Robot input = new Robot();
        Robot result = joyStickServiceImpl.transform(input, new PositionInstruction(new Coordinates(7,3),DirectionType.NORTH));
    }

    /**
     * This method will do a simple check for translating the robot by one position towards
     * NORTH
     * @throws Exception
     */
    @Test
    public void testTranslationTransform() throws Exception {
        Robot input = new Robot();
        input.setCoordinates(new Coordinates(2,3));
        input.setDirectionType(DirectionType.NORTH);

        Robot result = joyStickServiceImpl.transform(input, new TranslationInstruction());
        Assert.assertEquals(DirectionType.NORTH, result.getDirectionType());
        Assert.assertEquals(new Coordinates(2,4), result.getCoordinates());
    }

    /**
     * This method will check the translation failure.
     * @throws Exception
     */
    @Test(expected = TransformationException.class)
    public void testTranslationTransformFailure() throws Exception {
        Robot input = new Robot();
        input.setCoordinates(new Coordinates(2,4));
        input.setDirectionType(DirectionType.NORTH);

        Robot result = joyStickServiceImpl.transform(input, new TranslationInstruction());
    }

    /**
     * This test to check the report.
     * @throws Exception
     */
    @Test(expected = RobotMissingException.class)
    public void testReport() throws Exception {
        Robot result = joyStickServiceImpl.report();
        Assert.assertNotNull(result);
    }

    /**
     * This test to check the fetch robot method.
     * @throws Exception
     */
    @Test
    public void testFetchRobot() throws Exception {
        Robot result = joyStickServiceImpl.fetchRobot();
        Assert.assertNotNull(result);
    }
}
