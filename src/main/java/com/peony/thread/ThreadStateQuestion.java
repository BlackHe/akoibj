package com.peony.thread;


public class ThreadStateQuestion {

    static final Object monitor = new Object();

    public static void main(String[] args) {
        // 1.NEW
        Thread thread = new Thread(() -> {
            synchronized (monitor) {
                try {
                    // 3.WAITING
                    // 5.BLOCKED
                    monitor.wait();
                    // 4.TIMED_WAITING
                    monitor.wait(1000);
                }catch (InterruptedException e){

                }
            }
        });
        // 2.RUNNABLE
        thread.start(); // -> will to execute run()
        // 6.TERMINATED
    }
}
