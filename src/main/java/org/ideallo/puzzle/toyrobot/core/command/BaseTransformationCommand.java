package org.ideallo.puzzle.toyrobot.core.command;

import org.ideallo.puzzle.toyrobot.core.Base;
import org.ideallo.puzzle.toyrobot.core.object.Coordinates;
import org.ideallo.puzzle.toyrobot.core.object.Robot;
import org.ideallo.puzzle.toyrobot.core.object.TransformationException;

/**
 * @author akshay.zaveri
 */
public abstract class BaseTransformationCommand<T extends Base> extends Base implements TransformationCommand<Robot> {

    @Override
    public Robot preExecute(Robot instance) {
        return instance;
    }

    @Override
    public Robot postExecute(Robot instance) throws TransformationException {
        return instance;
    }
}
