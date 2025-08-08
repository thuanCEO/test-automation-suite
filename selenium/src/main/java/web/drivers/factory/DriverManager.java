package web.drivers.factory;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;

    public abstract void createDriver();

    public WebDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}