package web.pages.SafeRailway;

import org.openqa.selenium.WebDriver;
import utils.ElementUtil;
import utils.LocatorLoader;
import web.base.BaseTest;
import web.drivers.factory.DriverFactory;

public class GuerillamailPage extends BaseTest {
    private ElementUtil elementUtil;

    private String elementInputEmailWidget = LocatorLoader.getLocators("inputEmailWidget");
    private String elementInputCheckBox = LocatorLoader.getLocators("inputCheckBox");
    private String elementTableEmailList = LocatorLoader.getLocators("tableEmailList");

    public GuerillamailPage() {
        this.driver = DriverFactory.getDriver();
        this.elementUtil = new ElementUtil();
    }

    public void clickCheckBoxInput() {
        elementUtil.getElementByXpath(elementInputCheckBox).click();
    }

    public void getEmailText(){
        elementUtil.getElementByXpath(elementInputEmailWidget).getText();
    }

    public void checkNotificationEmail(){
        elementUtil.getElementByXpath(elementTableEmailList).isEnabled();
    }
}
