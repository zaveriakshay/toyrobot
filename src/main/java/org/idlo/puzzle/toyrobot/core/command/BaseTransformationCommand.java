package org.idlo.puzzle.toyrobot.core.command;

import org.idlo.puzzle.toyrobot.core.Base;
import org.idlo.puzzle.toyrobot.core.Robot;
import org.idlo.puzzle.toyrobot.core.exception.TransformationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author akshay.zaveri
 * This is an abstract class implementation for the Command Interface.
 */
public abstract class BaseTransformationCommand<T extends Base> extends Base implements TransformationCommand<Robot> {

    /**
     * This is the init method which can be used to set the values of instance
     * @param instance
     * @return
     */
    protected T intiCommmand(T instance){
        return instance;
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected void debug(String message) {
        logger.debug(message);
    }

    /**
     * This method will contain the transformation logic and udoate the object instance.
     * @param instance
     * @return
     * @throws TransformationException
     */
    @Override
    public Robot executeCommand(Robot instance) throws TransformationException {
        debug("executeCommand:is called");
        return TransformationCommand.super.executeCommand(instance);
    }

    /**
     * This method will contain the transformation logic and udoate the object instance.
     * @param instance
     * @return
     * @throws TransformationException
     */
    @Override
    public Robot execute(Robot instance) throws TransformationException {
        debug("execute:is called");
        return instance;
    }

    /**
     * This method can be implemented for any kind of validation or transformation before calling the execute method.
     * @param instance
     * @return
     * @throws TransformationException
     */
    @Override
    public Robot preExecute(Robot instance) throws TransformationException {
        debug("preExecute:is called");
        return instance;
    }

    /**
     * This method can be implemented for any kind of formatting after the execute method.
     * @param instance
     * @return
     * @throws TransformationException
     */
    @Override
    public Robot postExecute(Robot instance) throws TransformationException {
        debug("postExecute:is called");
        return instance;
    }
}
