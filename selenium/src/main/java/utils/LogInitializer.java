package utils;

import ch.qos.logback.core.joran.spi.JoranException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class LogInitializer {
    private static final Logger logger = LoggerFactory.getLogger(LogInitializer.class);

    public static void init() {
        try {
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
            File file = new File("src/main/resources/web/logback.xml");
            if (file.exists()) {
                JoranConfigurator configurator = new JoranConfigurator();
                configurator.setContext(context);
                context.reset();
                configurator.doConfigure(file.toURL());
                logger.info("✅ Logging initialized with custom logback.xml");
            } else {
                logger.error("❌ logback.xml not found at: " + file.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
