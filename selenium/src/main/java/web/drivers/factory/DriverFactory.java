package web.drivers.factory;

import org.openqa.selenium.WebDriver;
import web.drivers.browsers.ChromeManager;
import web.drivers.browsers.EdgeManager;
import web.drivers.browsers.FirefoxManager;

public class DriverFactory {
    private static final ThreadLocal<DriverManager> driverManager = new ThreadLocal<>();

    public static void initDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                driverManager.set(new ChromeManager());
                break;
            case "firefox":
                driverManager.set(new FirefoxManager());
                break;
            case "edge":
                driverManager.set(new EdgeManager());
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driverManager.get().createDriver();
    }

    public static WebDriver getDriver() {
        return driverManager.get().getDriver();
    }

    public static void quitDriver() {
        if (driverManager.get() != null) {
            driverManager.get().quitDriver();
            driverManager.remove();
        }
    }
}