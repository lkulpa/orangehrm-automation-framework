package utils;

import java.nio.file.Path;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertiesReader {

    private static Properties properties = new Properties();
    private static final Logger logger = Logger.getLogger(PropertiesReader.class.getName());

    public static void read(Path filePath) {
        try (InputStream inputStream = Files.newInputStream(filePath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            logger.severe("Failed to load properties file: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            logger.warning("Requested property key '" + key + "' does not exist or has no value assigned.");
        }
        return value;
    }
}