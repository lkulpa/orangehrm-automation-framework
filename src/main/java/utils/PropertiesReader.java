package utils;

import java.nio.file.Path;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Properties;

public class PropertiesReader {

    private static Properties properties = new Properties();

    public static void read(Path filePath) {
        try {
            InputStream inputStream = Files.newInputStream(filePath);
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}