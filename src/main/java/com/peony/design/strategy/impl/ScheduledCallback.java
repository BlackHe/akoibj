package com.peony.design.strategy.impl;

import com.peony.design.strategy.CallbackStrategy;

public class ScheduledCallback implements CallbackStrategy {
    @Override
    public String callback(String params) {
        System.out.println("Scheduled Callback...");
        return "Scheduled Callback...";
    }
}
