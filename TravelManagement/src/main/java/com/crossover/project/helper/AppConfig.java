package com.crossover.project.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author waqas.ali2
 */
public class AppConfig {

    private static Properties properties = null;
    private static final String FILE_NAME = "Configuration.properties";
    private static final Logger LOGGER = Logger.getLogger(AppConfig.class);

    private AppConfig() {}
    
    public static String getProperty(String property) {
        if (properties == null) {
            loadProperties();
        }

        String confval = properties.getProperty(property);

        return confval;
    }

    public static void loadProperties() {

        try {
            InputStream is = AppConfig.class.getResourceAsStream("/" + FILE_NAME);
            properties = new Properties();
            properties.load(is);
            is.close();

        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        } 
    }
}
