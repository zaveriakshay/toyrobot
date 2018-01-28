package org.idlo.puzzle.toyrobot.controller.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author akshay.zaveri
 * This class will handle the validations for the custom validation.
 * It will check if the coordinates are under a particular value.
 */
public class InRangeValidator implements ConstraintValidator<InRange, Integer> {

    private int min;
    private int max;

    /**
     * Going forward this can be changed and centralized wrt to App Constants.
     * @param constraintAnnotation
     */
    @Override
    public void initialize(InRange constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value == null || (value >= min && value <= max);
    }
}