package com.peony.event.domain.publisher;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class SpringDomainEventPublisher implements DomainEventPublisher{

    @Autowired
    private ApplicationContext context;

    @Override
    public void publishEvent(Object event) {
        context.publishEvent(event);
    }
}
