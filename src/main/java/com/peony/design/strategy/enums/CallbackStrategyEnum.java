package com.peony.design.strategy.enums;

import com.peony.design.strategy.impl.ScheduledCallback;
import com.peony.design.strategy.impl.SynchronizorCallback;

public enum CallbackStrategyEnum {

    SCHEDULED_CALLBACK(ScheduledCallback.class),
    SYNCHRONIZOR_CALLBACK(SynchronizorCallback.class);

    private Class strategyClass;

    CallbackStrategyEnum(Class strategyClass) {
        this.strategyClass = strategyClass;
    }

    public Class getStrategyClass() {
        return strategyClass;
    }
}
