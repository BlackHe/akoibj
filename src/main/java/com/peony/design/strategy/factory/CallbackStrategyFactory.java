package com.peony.design.strategy.factory;

import com.peony.design.strategy.CallbackStrategy;
import com.peony.design.strategy.enums.CallbackStrategyEnum;

public class CallbackStrategyFactory {
    public static CallbackStrategy getCallbackStrategy(String callStyle){
        CallbackStrategyEnum strategyEnum = CallbackStrategyEnum.valueOf(callStyle);
        Class strategyClass = strategyEnum.getStrategyClass();
        CallbackStrategy strategy = null;
        try{
            return (CallbackStrategy)strategyClass.newInstance();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


}
