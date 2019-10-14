package com.peony.concurrencyinpractice;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicSequenctFactorizer {

    private final static AtomicInteger nextValue = new AtomicInteger(0);

    private AtomicSequenctFactorizer(){};

    public static int getNext(){
        return nextValue.incrementAndGet();
    }
}
