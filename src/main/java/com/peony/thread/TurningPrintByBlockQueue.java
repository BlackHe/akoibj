package com.peony.thread;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 两个线程交替输出
 * 即线程1输出 ABCDEFG
 * 线程2输出 123456
 */
public class TurningPrintByBlockQueue {

    private final static char[] charsI = {'1', '2', '3', '4', '5', '6'};
    private final static char[] charsC = {'A', 'B', 'C', 'D', 'E', 'F'};

    private final static BlockingQueue<String> queue1 = new ArrayBlockingQueue<>(1);
    private final static BlockingQueue<String> queue2 = new ArrayBlockingQueue<>(1);

    private static Thread t1,t2;

    public static void main(String[] args) {
        t1 = new Thread(() -> {
            for (char c : charsI) {
                try {
                    queue1.take();
                    System.out.print(c);
                    queue2.put("ok");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t2 = new Thread(() -> {
            for (char c : charsC) {
                try {
                    queue2.take();
                    System.out.print(c);
                    queue1.put("ok");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            queue1.put("ok");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();
        t2.start();
    }
}
