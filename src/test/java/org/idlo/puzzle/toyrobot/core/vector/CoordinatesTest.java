package org.idlo.puzzle.toyrobot.core.vector;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CoordinatesTest {
    Coordinates coordinates = new Coordinates(Integer.valueOf(0), Integer.valueOf(0));

    @Test
    public void testAdd() throws Exception {
        coordinates.add(new Coordinates(Integer.valueOf(3), Integer.valueOf(4)));
        Assert.assertEquals(coordinates.getX(),Integer.valueOf(3));
        Assert.assertEquals(coordinates.getY(),Integer.valueOf(4));
    }

    @Test
    public void testIsWithinRange() throws Exception {
        coordinates.setX(4);
        coordinates.setY(4);
        Boolean result = coordinates.isWithinRange(new Coordinates(Integer.valueOf(1), Integer.valueOf(0)));
        Assert.assertEquals(Boolean.FALSE, result);

        coordinates.setX(3);
        coordinates.setY(4);
        result = coordinates.isWithinRange(new Coordinates(Integer.valueOf(1), Integer.valueOf(0)));
        Assert.assertEquals(Boolean.TRUE, result);
    }

    @Test
    public void testEquals() throws Exception {
        coordinates.setX(13);
        coordinates.setY(14);
        boolean result = coordinates.equals(new Coordinates(13,14));
        Assert.assertEquals(true, result);
    }
}