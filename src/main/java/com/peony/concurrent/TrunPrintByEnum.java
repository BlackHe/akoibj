package com.peony.concurrent;


public class TrunPrintByEnum {

    enum ReadRun{T1,T2}

    private volatile static ReadRun RUNNER = ReadRun.T1;

    private final static char[] AI = "1234567".toCharArray();
    private final static char[] AC = "ABCDEFG".toCharArray();

    public static void main(String[] args) {

        new Thread(() -> {
            for (char c : AI) {
                while (ReadRun.T1 != RUNNER){}
                System.out.print(c);
                RUNNER = ReadRun.T2;
            }
        },"t1").start();

        new Thread(() -> {
            for (char c : AC) {
                while (ReadRun.T2 != RUNNER){}
                System.out.print(c);
                RUNNER = ReadRun.T1;
            }
        },"t2").start();
    }
}
