package com.peony.concurrencyinpractice;

public class UnsafeCachingFactorizer {

    private int lastNumber;

    public int evaluator(int a) {
        if (a == lastNumber) {
            return lastNumber;
        }
        lastNumber = a;
        return a;
    }
}
