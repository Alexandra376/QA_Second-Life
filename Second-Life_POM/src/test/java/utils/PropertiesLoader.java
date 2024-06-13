package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    private static Properties testProperties;
    private static PropertiesLoader instance;

    private PropertiesLoader() throws IOException {
        testProperties = new Properties();
        testProperties.load(new FileInputStream("src/test/resources/test.properties"));
    }

    public static PropertiesLoader getInstance() throws IOException {
        if (instance == null) {
            instance = new PropertiesLoader();
        }
        return instance;
    }

    public static Properties getTestProperties() {
        return testProperties;
    }
}
