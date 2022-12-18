package java8.Logs;

import java.io.IOException;
import java.util.logging.*;

public class Handler {
    static Logger logger = Logger.getLogger("Java8.Logs");

    public static void main(String[] args) throws IOException {
        ConsoleHandler h = new ConsoleHandler();
        Formatter f = new SimpleFormatter();

        h.setFormatter(f);
        logger.addHandler(h);
        logger.setLevel(Level.INFO);
        logger.log(Level.INFO, "Here we go!");

//        fileHander();
    }

    private static void fileHander() throws IOException {
        FileHandler h = new FileHandler("%h/myapp_%g.log", 1000, 4);

        h.setFormatter(new SimpleFormatter());
        logger.addHandler(h);

        logger.log(Level.INFO, "Test 1");
        logger.log(Level.INFO, "Test 2");
        logger.log(Level.INFO, "Test 3");
        logger.log(Level.INFO, "Test 4");
        logger.log(Level.INFO, "Test 5");
        logger.log(Level.INFO, "Test 6");

    }
}
