package org.idlo.puzzle.toyrobot.service.impl;

import org.idlo.puzzle.toyrobot.service.BaseAbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author akshay.zaveri
 */
public class BaseAbstractServiceImpl implements BaseAbstractService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected void debug(String message) {
        logger.debug(message);
    }

}
