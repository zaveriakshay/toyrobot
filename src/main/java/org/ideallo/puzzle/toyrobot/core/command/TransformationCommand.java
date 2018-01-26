package org.ideallo.puzzle.toyrobot.core.command;

import org.ideallo.puzzle.toyrobot.core.Base;
import org.ideallo.puzzle.toyrobot.core.vector.TransformationException;

/**
 * @author akshay.zaveri
 */
public interface TransformationCommand<T extends Base> {

    public T execute(T instance);

    public T preExecute(T instance);

    public T postExecute(T instance) throws TransformationException;

    default T executeCommand(T instance){

        try{
            /**
             * Clone here, as back up, if exception occurs the alteration done by execute will not reflect.
             */
            T cloneInstance = preExecute(instance);


            /**
             *
             */
            execute(cloneInstance);


            postExecute(cloneInstance);
        }catch(Exception exception){
            throw exception;
        }

        return instance;
    }

}
