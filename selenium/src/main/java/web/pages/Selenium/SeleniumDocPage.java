package web.pages.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.base.BaseTest;
import web.constants.UrlConstants;
import web.locators.Selenium.SeleniumDocPageLocators;

public class SeleniumDocPage extends BaseTest {
    private WebDriver driver;

    public SeleniumDocPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(UrlConstants.SELENIUM_DOCUMENTATION_URL);
    }

    public String getHeaderTitle() {
        WebElement title = driver.findElement(SeleniumDocPageLocators.HEADER_TITLE);
        return title.getText();
    }
}
