package org.idlo.puzzle.toyrobot.core.command;

import org.idlo.puzzle.toyrobot.core.Base;
import org.idlo.puzzle.toyrobot.core.enums.ErrorType;
import org.idlo.puzzle.toyrobot.core.exception.TransformationException;

/**
 * @author akshay.zaveri
 * This is the Command interface, it will declare methods vital for any command execution
 */
public interface TransformationCommand<T extends Base> {

    /**
     * This method will contain the transformation logic and udoate the object instance.
     * @param instance
     * @return
     * @throws TransformationException
     */
    T execute(T instance) throws TransformationException;

    /**
     * This method can be implemented for any kind of validation or transformation before calling the execute method.
     * @param instance
     * @return
     * @throws TransformationException
     */
    T preExecute(T instance) throws TransformationException;

    /**
     * This method can be implemented for any kind of formatting after the execute method.
     * @param instance
     * @return
     * @throws TransformationException
     */
    T postExecute(T instance) throws TransformationException;

    default T executeCommand(T instance) throws TransformationException{

        try{
            /**
             * Invoke the pre-execute.
             */
            T cloneInstance = preExecute(instance);


            /**
             * Invoke the execute.
             */
            execute(cloneInstance);


            /**
             * Invoke the post execute.
             */
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
