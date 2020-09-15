package com.peony.concurrent;


public class TrunPrintByEnum {

    enum ReadyRun{T1,T2}

    private volatile static ReadyRun RUNNER = ReadyRun.T1;

    private final static char[] AI = "1234567".toCharArray();
    private final static char[] AC = "ABCDEFG".toCharArray();

    public static void main(String[] args) {

        new Thread(() -> {
            for (char c : AI) {
                while (ReadyRun.T1 != RUNNER){}
                System.out.print(c);
                RUNNER = ReadyRun.T2;
            }
        },"t1").start();

        new Thread(() -> {
            for (char c : AC) {
                while (ReadyRun.T2 != RUNNER){}
                System.out.print(c);
                RUNNER = ReadyRun.T1;
            }
        },"t2").start();
    }
}
