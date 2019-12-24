package com.peony.design.chainofresponsibility;

public abstract class AbstractLogger {

    public static final int CONSOLE = 1;

    public static final int FILE = 2;

    public static final int ERROR = 3;

    protected int level;

    private AbstractLogger nextLogger;

    public void log(int logLevel,String message){
        if (logLevel == level){
            write(message);
        }
        setNextLogger();
        if (nextLogger != null){
            nextLogger.log(logLevel,message);
        }
    }

    public void setNextLogger() {
        this.nextLogger = nextLogger();
    }

    protected abstract void write(String message);

    protected abstract AbstractLogger nextLogger();


}
