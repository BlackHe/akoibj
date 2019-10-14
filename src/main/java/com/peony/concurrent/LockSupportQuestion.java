package com.peony.concurrent;

import java.util.concurrent.locks.LockSupport;

public class LockSupportQuestion {
    public static void main(String[] args) {
        System.out.println("6666");
        LockSupport.park();
        System.out.println("777");
    }
}
