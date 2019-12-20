package com.peony.design.strategy.impl;

import com.peony.design.strategy.CallbackStrategy;

public class SynchronizorCallback implements CallbackStrategy {
    @Override
    public String callback(String params) {
        System.out.println("Synchronizor Callback...");
        return "Synchronizor Callback...";
    }
}
