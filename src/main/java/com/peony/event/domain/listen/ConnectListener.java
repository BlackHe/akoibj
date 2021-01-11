package com.peony.event.domain.listen;

import com.peony.event.domain.event.ConnectEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ConnectListener {

    @EventListener(ConnectEvent.class)
    public String onConnect(ConnectEvent event){
        System.out.println("lisened connect event: "+event.getClient());
        return "process ok";
    }
}
