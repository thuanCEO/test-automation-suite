package web.drivers.browsers;

import java.util.Arrays;
import java.util.List;

public class BrowserArguments {
    public static List<String> getCommonArgs() {
        return Arrays.asList(
                "--disable-notifications",
                "--disable-infobars",
                "--disable-popup-blocking",
                "--disable-extensions",
                "--no-sandbox",
                "--disable-dev-shm-usage"
        );
    }

    public static List<String> getHeadlessArgs() {
        return Arrays.asList(
                "--headless=new",
                "--window-size=1920,1080"
        );
    }

    public static List<String> getMobileEmulationArgs() {
        return Arrays.asList(
                "--window-size=375,812",
                "--user-agent=iPhone"
        );
    }
}
