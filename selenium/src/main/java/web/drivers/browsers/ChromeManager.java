package web.drivers.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import web.config.ConfigManager;
import web.drivers.factory.DriverManager;

import java.time.Duration;

import static web.constants.ConfigKeys.HEADLESS;
import static web.constants.TimeoutConstants.IMPLICIT_WAIT_MS;

public class ChromeManager extends DriverManager {
    @Override
    public void createDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(BrowserArguments.getCommonArgs());
        if (ConfigManager.get(HEADLESS).equals("true")) {
            options.addArguments(BrowserArguments.getHeadlessArgs());
        }
        options.addArguments("--start-maximized"); // exp add more
        driver = new ChromeDriver(options);
    }
}