package org.idlo.puzzle.toyrobot.controller.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author akshay.zaveri
 * This is the annotation created to handle custom validations
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { InRangeValidator.class })
public @interface InRange {
    String message() default "Value is out of range";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Going forward this can be changed and centralized wrt to App Constants.
     * @return
     */
    int min() default Integer.MIN_VALUE;

    /**
     * Going forward this can be changed and centralized wrt to App Constants.
     * @return
     */
    int max() default Integer.MAX_VALUE;
}