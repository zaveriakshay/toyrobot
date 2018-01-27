package org.idlo.puzzle.toyrobot.core.command;

import org.idlo.puzzle.toyrobot.core.Base;
import org.idlo.puzzle.toyrobot.core.Robot;
import org.idlo.puzzle.toyrobot.core.exception.TransformationException;

/**
 * @author akshay.zaveri
 */
public abstract class BaseTransformationCommand<T extends Base> extends Base implements TransformationCommand<Robot> {

    public T intiCommmand(T instance){
        return instance;
    }

    @Override
    public Robot preExecute(Robot instance) throws TransformationException {
        return instance;
    }

    @Override
    public Robot postExecute(Robot instance) throws TransformationException {
        return instance;
    }
}
