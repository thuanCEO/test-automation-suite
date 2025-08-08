package web.pages.SafeRailway;

import org.openqa.selenium.WebDriver;
import utils.ElementUtil;
import utils.LocatorLoader;
import web.base.BaseTest;
import web.drivers.factory.DriverFactory;

public class SaleRailwayPage extends BaseTest {
    private ElementUtil elementUtil;

    private String elementMenuOptions = LocatorLoader.getLocators("menuOptions","Register");

    public SaleRailwayPage() {
        this.driver = DriverFactory.getDriver();
        this.elementUtil = new ElementUtil();
    }

    public void clickMenuOptionRegister() {
        elementUtil.getElementByXpath(elementMenuOptions).click();
    }
}