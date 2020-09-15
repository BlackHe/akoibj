package com.peony.concurrent;

import java.util.concurrent.locks.LockSupport;

public class TrunPrintQuestion {

    private final static char[] AI = "1234567".toCharArray();
    private final static char[] AC = "ABCDEFG".toCharArray();

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {

        t1 = new Thread(() -> {
            for (char c : AI) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        },"t1");

        t2 = new Thread(() -> {
            for (char c : AC) {
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
