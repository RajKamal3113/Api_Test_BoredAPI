package listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private static Logger Log = LogManager.getLogger(Log.class.getName());

    public static void info(String message) {
        Log.info(message);
    }

}
