package com.peony.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 两个线程交替输出
 * 即线程1输出 ABCDEFG
 * 线程2输出 123456
 */
public class TurningPrintByAtomicInteger {

    private final static char[] charsI = {'1', '2', '3', '4', '5', '6'};
    private final static char[] charsC = {'A', 'B', 'C', 'D', 'E', 'F'};

    private static Thread t1,t2;

    private static AtomicInteger runPointer = new AtomicInteger();

    public static void main(String[] args) {

        t1 = new Thread(() -> {
            for (char c : charsI) {
                while (runPointer.get() != 1){};
                System.out.print(c);
                runPointer.set(2);
            }
        });

        t2 = new Thread(() -> {
            for (char c : charsC) {
                while (runPointer.get() != 2) {};
                System.out.print(c);
                runPointer.set(1);
            }
        });

        t1.start();
        t2.start();

        // 可以很轻松的控制先打印字母 还是 先打印 数字
        runPointer.set(1);
    }
}
