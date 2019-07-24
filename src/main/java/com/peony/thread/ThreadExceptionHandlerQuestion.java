package com.peony.thread;

public class ThreadExceptionHandlerQuestion {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler( (thread,throwable) -> {
            System.out.printf("thread name : [%s] , exception message : [%s]\n",thread.getName(),throwable.getMessage());
        });

        new Thread(() -> {
            System.out.printf("execute...\n");
            throw new RuntimeException("order id cant't be repeat");
        },"thread-001").start();
    }
}
