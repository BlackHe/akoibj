package com.peony.design.chainofresponsibility;


public class ClientTest {
    public static void main(String[] args) {
        AbstractLogger logger = new ConsoleLogger();
        logger.log(AbstractLogger.ERROR, "Error log");
        logger.log(AbstractLogger.FILE, "File log");
        logger.log(AbstractLogger.CONSOLE, "Console log");

        System.out.println();
        final AbstractLogger fileLogger = new FileLogger();
        fileLogger.log(AbstractLogger.ERROR, "Error log");
        fileLogger.log(AbstractLogger.FILE, "File log");
        fileLogger.log(AbstractLogger.CONSOLE, "Console log");

        System.out.println();
        final AbstractLogger errorLogger = new ErrorLogger();
        errorLogger.log(AbstractLogger.ERROR, "Error log");
        errorLogger.log(AbstractLogger.FILE, "File log");
        errorLogger.log(AbstractLogger.CONSOLE, "Console log");

    }
}
