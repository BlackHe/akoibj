package com.peony.design.chainofresponsibility;

public class FileLogger extends AbstractLogger {

    public FileLogger(){
        super.level = AbstractLogger.FILE;
    }

    @Override
    public void write(String message) {
        System.out.println(this.getClass().getName() + ": " + message);
    }

    @Override
    public AbstractLogger nextLogger() {
        return new ErrorLogger();
    }
}
