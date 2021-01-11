package com.peony.event.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.AbstractApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class AsyncableEventMulticaster extends AbstractApplicationEventMulticaster {

    private Executor executor = Executors.newFixedThreadPool(5);

    @Override
    public void multicastEvent(ApplicationEvent event) {
        multicastEvent(event,ResolvableType.forInstance(event));
    }

    @Override
    public void multicastEvent(ApplicationEvent event, @Nullable ResolvableType eventType) {
        Collection<ApplicationListener<?>> listeners = getApplicationListeners(event, eventType);
        listeners.stream().forEach(i -> {
            invokeLisenter(i,event,eventType);
        });

    }

    public void invokeLisenter(ApplicationListener listener,ApplicationEvent event, ResolvableType eventType){
        if (event instanceof AsyncableApplicationEvent){
            AsyncableApplicationEvent asyncEvent = (AsyncableApplicationEvent)event;
            if (asyncEvent.asyncExecute()){
                executor.execute(() -> listener.onApplicationEvent(event));
            }else {
                listener.onApplicationEvent(event);
            }
        }

    }
}
