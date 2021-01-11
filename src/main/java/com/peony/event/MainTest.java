package com.peony.event;

import com.peony.event.domain.event.ConnectEvent;
import com.peony.event.domain.publisher.DomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MainTest {



    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(MainTest.class);
        DomainEventPublisher domainEventPublisher = context.getBean(DomainEventPublisher.class);
        new MainTest().publish(domainEventPublisher);
    }

    public void publish(DomainEventPublisher domainEventPublisher){
        domainEventPublisher.publishEvent(new ConnectEvent(this,"187.99.0.98"));
    }
}
