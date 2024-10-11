package com.entrata.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigReader {

    private static Logger log  = LogManager.getLogger("Property");
    private static Properties properties;

    /**
     * Get properties file.
     */
    public static Properties getProperties(String propertyFilePath) {
        try {
            File propFile = new File(propertyFilePath);
            FileInputStream inputStream = new FileInputStream(propFile);
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
        } catch (Exception exp) {
            exp.printStackTrace();
            log.error(exp.getMessage());
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
        return properties;
    }

    /**
     * Get String Data from any properties file
     * @param propPath
     * @param key
     * @return
     */
    public static String getProperty(String propPath, String key) {
        return getProperties(propPath).getProperty(key);
    }


}
