package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static String timestamp() {
        return LocalDateTime.now().format(FORMATTER);
    }

    public static void info(String message) {
        System.out.println("[INFO]  [" + timestamp() + "] " + message);
    }

    public static void debug(String message) {
        System.out.println("[DEBUG] [" + timestamp() + "] " + message);
    }

    public static void warn(String message) {
        System.out.println("[WARN]  [" + timestamp() + "] " + message);
    }

    public static void error(String message) {
        System.err.println("[ERROR] [" + timestamp() + "] " + message);
    }
}