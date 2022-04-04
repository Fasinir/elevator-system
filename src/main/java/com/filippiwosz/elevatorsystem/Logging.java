package com.filippiwosz.elevatorsystem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Filip Piwosz
 */
public class Logging {
    private static final Logger logger = LogManager.getLogger("Logger");

    private Logging() {
    }

    public static void error(Object message) {
        logger.error(message);
    }

    public static void info(Object message) {
        logger.info(message);
    }
}
