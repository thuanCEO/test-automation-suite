package web.drivers.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import web.config.ConfigManager;
import web.drivers.factory.DriverManager;

import java.time.Duration;

import static web.constants.ConfigKeys.HEADLESS;
import static web.constants.TimeoutConstants.IMPLICIT_WAIT_MS;

public class FirefoxManager extends DriverManager {
    @Override
    public void createDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(BrowserArguments.getCommonArgs());
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(IMPLICIT_WAIT_MS));
        if (ConfigManager.get(HEADLESS).equals("true")) {
            options.addArguments(BrowserArguments.getHeadlessArgs());
        }
        options.addArguments("--width=1920", "--height=1080");
        driver = new FirefoxDriver(options);
    }
}