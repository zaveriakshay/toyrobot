package org.idlo.puzzle.toyrobot.core.command;

import org.idlo.puzzle.toyrobot.core.Base;
import org.idlo.puzzle.toyrobot.core.enums.ErrorType;
import org.idlo.puzzle.toyrobot.core.exception.TransformationException;

/**
 * @author akshay.zaveri
 */
public interface TransformationCommand<T extends Base> {

    T execute(T instance) throws TransformationException;

    T preExecute(T instance) throws TransformationException;

    T postExecute(T instance) throws TransformationException;

    default T executeCommand(T instance) throws TransformationException{

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
            if(exception instanceof TransformationException){
                throw exception;
            }else{
                throw new TransformationException(ErrorType.ERR0003);
            }
        }

        return instance;
    }

}
