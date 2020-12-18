package com.peony.thread;

/**
 * 两个线程交替输出
 * 即线程1输出 ABCDEFG
 * 线程2输出 123456
 */
public class TurningPrintByVolatile {

    private final static char[] charsI = {'1', '2', '3', '4', '5', '6'};
    private final static char[] charsC = {'A', 'B', 'C', 'D', 'E', 'F'};

    enum RunThreadType{
        T1,T2
    }

    private static volatile RunThreadType readToRun = RunThreadType.T1;

    private static Thread t1, t2;

    public static void main(String[] args) {

        t1 = new Thread(() -> {
            for (char c : charsI) {
                while (readToRun != RunThreadType.T1){};
                System.out.print(c);
                readToRun = RunThreadType.T2;
            }
        });

        t2 = new Thread(() -> {
            for (char c : charsC) {
                while (readToRun != RunThreadType.T2){};
                System.out.print(c);
                readToRun = RunThreadType.T1;
            }
        });

        t1.start();
        t2.start();
    }

}
