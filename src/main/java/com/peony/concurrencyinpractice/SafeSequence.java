package com.peony.concurrencyinpractice;

public class SafeSequence {

    private int nextValue;

    public synchronized int getNext(){
        return nextValue++;
    }
}
