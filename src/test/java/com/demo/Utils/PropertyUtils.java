package com.demo.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {

    public static String getProperty(String key) {
        Properties props = new Properties();
        InputStream is = ClassLoader.getSystemResourceAsStream("properties/ui.properties");

        try {
            props.load(is);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return props.getProperty(key);
    }

    public static String getConfigProperty(String key) {
        Properties props = new Properties();
        InputStream is = ClassLoader.getSystemResourceAsStream("properties/config.properties");

        try {
            props.load(is);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return props.getProperty(key);
    }
}
