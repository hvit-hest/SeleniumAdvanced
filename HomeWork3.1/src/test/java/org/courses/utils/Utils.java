package org.courses.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {

    public void printTestingProperties() {
        Properties prop = loadPropertiesFile("testconfig.properties");
        prop.forEach((k, v) -> System.out.println(k + " " + v));
    }

    private Properties loadPropertiesFile(String filePath) {
        Properties prop = new Properties();
        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException ioe) {
            System.err.println("Unable to load properties file:" + filePath);
        }
        return prop;
    }

    public Properties getTestProperties() {
        return loadPropertiesFile("testconfig.properties");
    }
}
