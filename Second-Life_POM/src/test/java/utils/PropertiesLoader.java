package utils;

import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    @Getter
    private static Properties testProperties;
    @Getter
    private static Properties httpProperties;
    private static PropertiesLoader instance;

    private PropertiesLoader() throws IOException {
        testProperties = new Properties();
        httpProperties = new Properties();

        testProperties.load(new FileInputStream("src/test/resources/test.properties"));
        httpProperties.load(new FileInputStream("src/test/resources/http.properties"));
    }

    public static void getInstance() throws IOException {
        if (instance == null) {
            instance = new PropertiesLoader();
        }
    }
}
