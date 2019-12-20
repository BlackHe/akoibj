package com.peony.design.strategy;

import com.peony.design.strategy.enums.CallbackStrategyEnum;
import com.peony.design.strategy.factory.CallbackStrategyFactory;

public class ClientContext {

    public static void main(String[] args) {
        new ClientContext().callback(CallbackStrategyEnum.SCHEDULED_CALLBACK.name(),"hello");
    }

    public String callback(String callStyle,String params){
        CallbackStrategy callbackStrategy = CallbackStrategyFactory.getCallbackStrategy(callStyle);
        return callbackStrategy.callback(params);
    }
}
