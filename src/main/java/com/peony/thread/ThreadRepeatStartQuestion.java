package com.peony.thread;

public class ThreadRepeatStartQuestion {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("start");
        });
        thread.start();
        thread.start();
    }
}