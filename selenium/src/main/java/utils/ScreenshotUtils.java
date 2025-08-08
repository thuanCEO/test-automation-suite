package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import web.drivers.factory.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {
    private static final String SCREENSHOT_DIR = "src/test/java/reports/screenshots/";

    public static String takeScreenshot(String testName) {
        WebDriver driver = DriverFactory.getDriver();
        if (driver == null) {
            LogUtils.warn("Driver is null. Cannot take screenshot.");
            return null;
        }

        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotName = testName + "_" + timestamp + ".png";

            File destFile = new File(SCREENSHOT_DIR + screenshotName);
            destFile.getParentFile().mkdirs(); // tạo thư mục nếu chưa có
            Files.copy(screenshot.toPath(), destFile.toPath());

            LogUtils.info("Screenshot saved: " + destFile.getAbsolutePath());
            return destFile.getAbsolutePath();

        } catch (IOException e) {
            LogUtils.error("Failed to take screenshot: " + e.getMessage());
            return null;
        }
    }
}
