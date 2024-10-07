package com.timesmed.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExpectedUtils {
	
	private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/expected.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getExpectedData(String key) {
        return properties.getProperty(key);
    }

}
