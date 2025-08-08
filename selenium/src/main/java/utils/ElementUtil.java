package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.base.BaseTest;
import web.drivers.factory.DriverFactory;

import java.time.Duration;

public class ElementUtil extends BaseTest {
    private WebDriver driver;

    public ElementUtil() {
        this.driver = DriverFactory.getDriver();
    }

    public static String format(String xpathTemplate, String value) {
        return String.format(xpathTemplate, value);
    }

    public WebElement getElement(String key, String... params) {
        String xpath = LocatorLoader.getLocators(key, params);
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getElementByXpath(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }

    public void fillInputByXpath(String xpath, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        element.clear();
        element.sendKeys(value);
    }
}