package com.Ecommerce;

import org.apache.log4j.Logger;

import java.io.IOException;

public class TestLog4j1 {

    private static Logger logger = Logger.getLogger(TestLog4j1.class);

    public static void main(String[] args) throws IOException {



        //Log in console in and log file

        logger.debug("Log4j appender configuration is successful !!");
        logger.debug("msg de debogage");
        logger.info("msg d'information");
        logger.warn("msg d'avertissement");
        logger.error("msg d'erreur");
        logger.fatal("msg d'erreur fatale");
    }
}
