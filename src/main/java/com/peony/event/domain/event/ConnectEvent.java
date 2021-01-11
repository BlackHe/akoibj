package com.peony.event.domain.event;

import org.springframework.context.ApplicationEvent;


public class ConnectEvent extends ApplicationEvent {

    private String client;


    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public ConnectEvent(Object source) {
        super(source);
    }

    public ConnectEvent(Object source, String client) {
        super(source);
        this.client = client;
    }


    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
