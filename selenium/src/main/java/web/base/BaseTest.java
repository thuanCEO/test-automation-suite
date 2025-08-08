package web.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.ExtentReportManager;
import utils.LogInitializer;
import utils.LogUtils;
import utils.ScreenshotUtils;
import web.config.ConfigManager;
import web.drivers.factory.DriverFactory;

import java.lang.reflect.Method;

public class BaseTest {
    protected static ExtentReports extent;
    protected static ExtentTest test;
    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setupReport() {
        LogInitializer.init(); // init logger
        extent = ExtentReportManager.getInstance(); // init extent
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpAndStartTest(Method method) {
        // Bắt đầu log
        LogUtils.info("========== START TEST: " + method.getName() + " ==========");

        // Start extent report
        test = extent.createTest(method.getName());

        // Khởi tạo browser
        String browser = ConfigManager.get("browser");
        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();

        // Truy cập URL nếu có
        String baseUrl = ConfigManager.get("baseUrl");
        if (baseUrl != null && !baseUrl.isEmpty()) {
            driver.get(baseUrl);
            LogUtils.info("Navigated to baseUrl: " + baseUrl);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        String testName = result.getMethod().getMethodName();

        if (!result.isSuccess()) {
            LogUtils.error("❌ TEST FAILED: " + testName);
            ScreenshotUtils.takeScreenshot(testName);
        } else {
            LogUtils.info("✅ TEST PASSED: " + testName);
        }

        DriverFactory.quitDriver();
        LogUtils.info("========== END TEST: " + testName + " ==========\n");
    }

    @AfterSuite(alwaysRun = true)
    public void flushReport() {
        extent.flush();
    }

    @AfterSuite
    public void afterSuite() {
        utils.AllureReportUtils.generateAndOpenAllureReport();
    }
}
