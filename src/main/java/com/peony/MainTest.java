package com.peony;


public class MainTest {

    private static Thread t1 = null;
    private static Thread t2 = null;
    private static Thread t3 = null;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("main begin");
        t1 = new Thread(() -> {
            try {
                t2.join();
                System.out.println("t1...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2 = new Thread(() -> {
            try {
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2...");
        });
        t3 = new Thread(() -> {
            System.out.println("t3...");
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();

        System.out.println("main end");

    }

}
