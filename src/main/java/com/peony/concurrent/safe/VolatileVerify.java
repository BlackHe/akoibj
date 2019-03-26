package com.peony.concurrent.safe;

public class VolatileVerify {
    private volatile int a = 0;

    public void set() {
        a++;
    }
}
