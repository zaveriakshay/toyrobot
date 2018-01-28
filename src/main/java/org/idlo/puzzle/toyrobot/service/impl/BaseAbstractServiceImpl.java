package org.idlo.puzzle.toyrobot.service.impl;

import org.idlo.puzzle.toyrobot.service.BaseAbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author akshay.zaveri
 * This is root class for all the services. In future it can be a generic implementation for all of the services.
 */
public class BaseAbstractServiceImpl implements BaseAbstractService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * The logger method, in future this can be replcaed with Aspects.
     * @param message
     */
    protected void debug(String message) {
        logger.debug(message);
    }

}
