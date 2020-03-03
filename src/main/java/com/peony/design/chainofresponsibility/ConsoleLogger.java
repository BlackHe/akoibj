package com.peony.design.chainofresponsibility;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger() {
        super.level = AbstractLogger.CONSOLE;
    }

    @Override
    public void write(String message) {
        System.out.println(this.getClass().getName() + ": " + message);
    }

    @Override
    public AbstractLogger nextLogger() {
        return new FileLogger();
    }
}
