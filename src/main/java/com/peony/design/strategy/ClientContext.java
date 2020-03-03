package com.peony.design.strategy;

import com.peony.design.strategy.enums.CallbackStrategyEnum;
import com.peony.design.strategy.factory.CallbackStrategyFactory;
import com.peony.design.strategy.impl.ScheduledCallback;
import com.peony.design.strategy.impl.SynchronizorCallback;

public class ClientContext {

    static {
        CallbackStrategyFactory.register(CallbackStrategyEnum.SCHEDULED_CALLBACK.name(), new ScheduledCallback());
        CallbackStrategyFactory.register(CallbackStrategyEnum.SYNCHRONIZOR_CALLBACK.name(), new SynchronizorCallback());
    }


    public static void main(String[] args) {
        new ClientContext().callback(CallbackStrategyEnum.SYNCHRONIZOR_CALLBACK.name(), "hello");
    }

    public String callback(String callStyle, String params) {
        CallbackStrategy callbackStrategy = CallbackStrategyFactory.getCallbackStrategy(callStyle);
        return callbackStrategy.callback(params);
    }
}
