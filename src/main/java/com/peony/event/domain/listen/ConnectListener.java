package com.peony.event.domain.listen;

import com.peony.event.domain.event.ConnectEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ConnectListener {

    @EventListener(ConnectEvent.class)
    @Async
    public String onConnect(ConnectEvent event){
        System.out.println(Thread.currentThread().getName()+" lisened connect event: "+event.getClient());
        return "process ok";
    }
}
