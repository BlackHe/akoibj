package com.peony.utils;

import java.util.concurrent.TimeUnit;

public class SleepUtils {

    public static void sleep(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
