package gaspoverka.util;

import java.util.logging.*;

public class Log {
    static private FileHandler logFile;
    static private ConsoleHandler console;

    static public void setup() {
        try {
            Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
            logFile = new FileHandler("console.log");
            console = new ConsoleHandler();
            logFile.setFormatter(new SimpleFormatter());
            console.setFormatter(new SimpleFormatter());
            logger.addHandler(logFile);
            logger.addHandler(console);
            logger.setLevel(Level.INFO);
            logger.log(Level.INFO, "Log setup");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
