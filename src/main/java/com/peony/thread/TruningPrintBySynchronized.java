package com.peony.thread;


/**
 * 两个线程交替输出
 * 即线程1输出 ABCDEFG
 * 线程2输出 123456
 */
public class TruningPrintBySynchronized {

    private final static char[] charsI = {'1', '2', '3', '4', '5', '6'};
    private final static char[] charsC = {'A', 'B', 'C', 'D', 'E', 'F'};

    private final static Object monitor = new Object();

    private static Thread t1, t2;


    public static void main(String[] args) {
        t1 = new Thread(() -> {
            synchronized (monitor) {
                for (char c : charsC) {
                    System.out.print(c);
                    monitor.notify();
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 如果循环外面，即打印完后，不notify一下，则肯定有一个线程一直在wait状态，程序无法退出；
                monitor.notify();
            }
        });

        t2 = new Thread(() -> {
            synchronized (monitor) {
                for (char c : charsI) {
                    System.out.print(c);
                    monitor.notify();
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                // 如果循环外面，即打印完后，不notify一下，则肯定有一个线程一直在wait状态，程序无法退出；
                monitor.notify();
            }
        });

        t1.start();
        t2.start();
    }
}
