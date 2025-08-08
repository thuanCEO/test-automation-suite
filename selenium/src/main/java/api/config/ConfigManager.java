package api.config;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static final Properties properties = new Properties();
    private static final String CONFIG_FILE = "/config.properties";

    static {
        try (InputStream input = ConfigManager.class.getResourceAsStream(CONFIG_FILE)) {
            if (input == null) {
                throw new RuntimeException("⚠️ Cannot find " + CONFIG_FILE);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("❌ Failed to load config: " + e.getMessage(), e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String getEnv() {
        return get("env");
    }

    public static String getBaseUrl() {
        String env = getEnv();
        return get("base.url." + env);
    }

    public static String getDefaultToken() {
        return get("default.token");
    }
}