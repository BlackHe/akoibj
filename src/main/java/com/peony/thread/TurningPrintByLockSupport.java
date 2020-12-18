package com.peony.thread;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * 两个线程交替输出
 * 即线程1输出 ABCDEFG
 * 线程2输出 123456
 */
public class TurningPrintByLockSupport {

    private static final char[] charI = "123456".toCharArray();
    private static final char[] charC = "ABCDEF".toCharArray();

    private static Thread t1,t2;

    public static void main(String[] args) {

        t1 = new Thread(() ->{
            for (char c : charI) {
                System.out.print(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });

        t2 = new Thread(() ->{
            for (char c : charC) {
                LockSupport.park();
                System.out.print(c);
                LockSupport.unpark(t1);
            }
        });

        t1.start();
        t2.start();
    }



}
