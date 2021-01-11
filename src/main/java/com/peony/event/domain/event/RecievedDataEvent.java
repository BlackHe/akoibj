package com.peony.event.domain.event;

import com.peony.event.spring.AbstractAsyncableApplicationEvent;


public class RecievedDataEvent extends AbstractAsyncableApplicationEvent {

    private String data;

    public RecievedDataEvent(Object source) {
        super(source,true);
    }

    public RecievedDataEvent(Object source,String data) {
        super(source,true);
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
