package utils;

import org.testng.IExecutionListener;

import java.io.IOException;

public class AllureListenerRunner implements IExecutionListener {

        @Override
        public void onExecutionFinish() {
            try {
                LogUtils.info("🧪 Generating Allure report...");
                Process generate = Runtime.getRuntime().exec("allure generate target/allure-results --clean -o target/allure-report");
                generate.waitFor();
                LogUtils.info("🌐 Opening Allure report in browser...");
                Runtime.getRuntime().exec("allure open target/allure-report");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }