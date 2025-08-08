package web.drivers.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import web.config.ConfigManager;
import web.drivers.factory.DriverManager;

import java.time.Duration;

import static web.constants.ConfigKeys.HEADLESS;
import static web.constants.TimeoutConstants.IMPLICIT_WAIT_MS;

public class EdgeManager extends DriverManager {
    @Override
    public void createDriver() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments(BrowserArguments.getCommonArgs());
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(IMPLICIT_WAIT_MS));
        if (ConfigManager.get(HEADLESS).equals("true")) {
            options.addArguments(BrowserArguments.getHeadlessArgs());
        }
        options.addArguments("start-maximized");
        driver = new EdgeDriver(options);
    }
}