package web.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static final Properties props = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/web/config.properties");
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Could not load config.properties file", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}