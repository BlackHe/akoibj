package com.peony.concurrent.safe;

public class ClassVerify {
    private int n = 5;

    public int count() {
        synchronized (ClassVerify.class) {
            n++;
        }
        return n;
    }
}
