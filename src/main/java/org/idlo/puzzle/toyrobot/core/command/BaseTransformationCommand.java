package org.idlo.puzzle.toyrobot.core.command;

import org.idlo.puzzle.toyrobot.core.Base;
import org.idlo.puzzle.toyrobot.core.Robot;
import org.idlo.puzzle.toyrobot.core.exception.TransformationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author akshay.zaveri
 */
public abstract class BaseTransformationCommand<T extends Base> extends Base implements TransformationCommand<Robot> {

    public T intiCommmand(T instance){
        return instance;
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected void debug(String message) {
        logger.debug(message);
    }

    @Override
    public Robot executeCommand(Robot instance) throws TransformationException {
        debug("executeCommand:is called");
        return TransformationCommand.super.executeCommand(instance);
    }

    @Override
    public Robot execute(Robot instance) throws TransformationException {
        debug("execute:is called");
        return instance;
    }

    @Override
    public Robot preExecute(Robot instance) throws TransformationException {
        debug("preExecute:is called");
        return instance;
    }

    @Override
    public Robot postExecute(Robot instance) throws TransformationException {
        debug("postExecute:is called");
        return instance;
    }
}
