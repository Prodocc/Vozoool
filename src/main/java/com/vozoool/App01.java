package com.vozoool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App01 {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("Logger test - info");
        logger.debug("Logger test - debug");
        logger.warn("Logger test - warn");
        logger.error("Logger test - error");
        logger.fatal("Logger test - fatal");
    }
}
