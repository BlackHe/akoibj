package com.peony.design.chainofresponsibility;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(){
        super.level = AbstractLogger.ERROR;
    }


    @Override
    public void write(String message) {
        System.out.println(this.getClass().getName() + ": " + message);
    }


    @Override
    public AbstractLogger nextLogger() {
        return null;
    }
}
