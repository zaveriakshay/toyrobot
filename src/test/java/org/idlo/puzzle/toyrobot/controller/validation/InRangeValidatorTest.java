package org.idlo.puzzle.toyrobot.controller.validation;

import org.junit.Assert;
import org.junit.Test;

import javax.validation.Payload;

import java.lang.annotation.Annotation;

import static org.mockito.Mockito.when;

public class InRangeValidatorTest {
    InRangeValidator inRangeValidator = new InRangeValidator();

    @Test
    public void testIsValid() throws Exception {

        InRange inRange = new InRange(){
            @Override
            public Class<? extends Annotation> annotationType() {
                return InRange.class;
            }

            @Override
            public String message() {
                return null;
            }

            @Override
            public Class<?>[] groups() {
                return new Class[0];
            }

            @Override
            public Class<? extends Payload>[] payload() {
                return new Class[0];
            }

            @Override
            public int min() {
                return 0;
            }

            @Override
            public int max() {
                return 4;
            }
        };
        inRangeValidator.initialize(inRange);
        boolean result = inRangeValidator.isValid(Integer.valueOf(5), null);
        Assert.assertEquals(false, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme