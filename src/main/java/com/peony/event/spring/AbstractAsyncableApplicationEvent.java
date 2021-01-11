package com.peony.event.spring;

import org.springframework.context.ApplicationEvent;

public abstract class AbstractAsyncableApplicationEvent extends ApplicationEvent implements AsyncableApplicationEvent {

    private boolean isAsync ;

    public AbstractAsyncableApplicationEvent(Object source) {
        super(source);
        this.isAsync = true;
    }

    public AbstractAsyncableApplicationEvent(Object source, boolean isAsync) {
        super(source);
        this.isAsync = isAsync;
    }

    @Override
    public boolean asyncExecute() {
        return isAsync;
    }

}
