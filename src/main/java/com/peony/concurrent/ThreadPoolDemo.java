package com.peony.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {

    private int counter = 0;



    public int getCounterAndIncrement(){
        return counter++;
    }
}
