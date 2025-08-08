package utils;

import java.net.URL;

public class JoranConfigurator {
    private LoggerContext context;

    public void setContext(LoggerContext context) {
        this.context = context;
    }

    public void doConfigure(URL configFile) {
        System.out.println("[MOCK] Configured logger using: " + configFile);
    }
}
