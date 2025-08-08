package web.drivers.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import web.config.ConfigManager;
import web.drivers.factory.DriverManager;

import static web.constants.ConfigKeys.HEADLESS;

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