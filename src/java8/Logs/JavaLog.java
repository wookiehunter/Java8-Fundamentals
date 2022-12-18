package java8.Logs;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class JavaLog {
    static Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
//        LogManager lm = LogManager.getLogManager();
//        Logger logger = lm.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.setLevel(Level.INFO); // anything below this level will be ignored
        logger.log(Level.INFO, "Message 1");
        logger.log(Level.INFO, "Message 2");
        logger.severe("Not Ignored");
        logger.fine("Ignored");

        // parameterised
        logger.log(Level.INFO, "{0} is my jam!", "Java");
        logger.log(Level.INFO, "My name is {0} and I live is {1} with my {2}.",
                new Object[]{"Steven", "England", "family"});


    }

}
