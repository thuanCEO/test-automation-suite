package tests.web.SafeRailway;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.LocatorLoader;
import web.base.BaseTest;
import web.constants.PathConstants;
import web.pages.SafeRailway.RegisterPage;
import web.pages.SafeRailway.SaleRailwayPage;

import static web.constants.UrlConstants.SAFE_RAILWAY_URL;

@Epic("Selenium Website")
@Feature("Header Verification")
public class RegisterAccount  extends BaseTest {
    private PathConstants pathConstants;
    private SaleRailwayPage salePage;
    private RegisterPage registerPage;

    @BeforeMethod
    public void setupLocators() {
        LocatorLoader.clear();
        LocatorLoader.loadMultiple(pathConstants.SAFE_RAILWAY_LOCATOR_FILE,pathConstants.REGISTER_PAGE_LOCATOR_FILE);
        driver.get(SAFE_RAILWAY_URL);
        salePage = new SaleRailwayPage();
        registerPage = new RegisterPage();
    }

    @Test(description = "Navigate To Register Page")
    @Severity(SeverityLevel.NORMAL)
    @Story("Register Account")
    public void testNavigateToRegisterPage() throws InterruptedException {
        salePage.clickMenuOptionRegister();

        registerPage.registerNewAccount(
                "sssaaaaaaa@gmail.com",
                "23232323",
                "23232323",
                "23232323");


        Thread.sleep(10000);

    }
}
