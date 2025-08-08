package utils;

import java.io.IOException;

public class AllureReportUtils {
    public static void generateAndOpenAllureReport() {
        try {
            Process generate = Runtime.getRuntime().exec("allure generate target/allure-results --clean -o target/allure-report");
            generate.waitFor();

            Process open = Runtime.getRuntime().exec("allure open target/allure-report");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
