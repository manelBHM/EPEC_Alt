package com.Ecommerce;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Properties;

public class Log4jPropertiesConfigurationExample {

    static Logger logger = Logger.getLogger(Log4jPropertiesConfigurationExample.class);
    public static void main(String[] args)
    {
        logger.debug("msg de debogage");
        logger.info("msg d'information");
        logger.warn("msg d'avertissement");
        logger.error("msg d'erreur");
        logger.fatal("msg d'erreur fatale");
    }
}
