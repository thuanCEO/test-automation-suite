package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class LocatorLoader {
    private static final Map<String, String> locators = new HashMap<>();

    /**
     * Load 1 file JSON vào map locators. Dữ liệu mới sẽ được gộp vào (không ghi đè toàn bộ map).
     */
    public static void load(String fileName) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getLocatorFileInputStream(fileName);
            Map<String, String> fileLocators = mapper.readValue(is, Map.class);

            // Gộp dữ liệu vào map chính
            locators.putAll(fileLocators);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load locator file: " + fileName);
        }
    }

    /**
     * Load nhiều file một lúc
     */
    public static void loadMultiple(String... fileNames) {
        for (String file : fileNames) {
            load(file);
        }
    }

    /**
     * Trả về locator theo key, có thể chèn args nếu là template
     */
    public static String getLocators(String key, String... args) {
        if (locators.isEmpty()) {
            throw new RuntimeException("Locator file not loaded. Call LocatorLoader.load(fileName) first.");
        }

        String template = locators.get(key);
        if (template == null) {
            throw new RuntimeException("Locator not found for key: " + key);
        }

        return String.format(template, (Object[]) args);
    }

    /**
     * Xóa tất cả locator đã load (nếu cần reset lại giữa các test)
     */
    public static void clear() {
        locators.clear();
    }

    /**
     * Lấy input stream từ file trong thư mục src/main/java/web/locators/
     */
    public static InputStream getLocatorFileInputStream(String fileName) {
        try {
            String path = Paths.get("src", "main", "java", "web", "locators", fileName).toString();
            System.out.println("Loading file from: " + path);
            return new FileInputStream(path);
        } catch (Exception e) {
            throw new RuntimeException("File not found: " + fileName, e);
        }
    }
}
