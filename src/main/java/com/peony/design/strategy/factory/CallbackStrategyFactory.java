package com.peony.design.strategy.factory;

import com.peony.design.strategy.CallbackStrategy;
import com.peony.design.strategy.enums.CallbackStrategyEnum;

import java.util.concurrent.ConcurrentHashMap;

public class CallbackStrategyFactory {

    private static ConcurrentHashMap<String, CallbackStrategy> strategyPool = new ConcurrentHashMap<>();


    public static void register(String callStyle, CallbackStrategy callbackStrategy) {
        strategyPool.put(callStyle, callbackStrategy);
    }

    public static CallbackStrategy getCallbackStrategy(String callStyle) {
        return strategyPool.get(callStyle);
    }


}
