package gaspoverka.util;

import java.util.logging.*;

public class Log {

    private static Log _instance = null;
    static final String filename = "console.log";
    static final Logger logger = Logger.getLogger(filename);
    FileHandler logFile;
    ConsoleHandler console;

    public Log() {
        try {
            logFile = new FileHandler(filename);
            console = new ConsoleHandler();
            logFile.setFormatter(new SimpleFormatter());
            logger.addHandler(logFile);
            logger.addHandler(console);
            if (logger != null) {
                logger.log(Level.INFO, "Log enable");
            }
        } catch (Exception e) {
        }
    }

    public final void out(String str) {
        try {
            if (logger != null) {
                logger.log(Level.INFO, str);
            }
        } catch (Exception e) {
        }
    }

    public final Logger from() {
                return logger;
    }

    public synchronized static Log getInstance() {
        if (_instance == null) {
            _instance = new Log();
        }
        return _instance;
    }
}
