package com.peony.event;

import com.peony.event.domain.event.ConnectEvent;
import com.peony.event.domain.event.RecievedDataEvent;
import com.peony.event.domain.publisher.DomainEventPublisher;
import com.peony.event.spring.AsyncableEventMulticaster;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.concurrent.*;

@Configuration
@ComponentScan
public class MainTest implements ApplicationContextAware {



    private ApplicationContext context;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(MainTest.class);
        DomainEventPublisher domainEventPublisher = context.getBean(DomainEventPublisher.class);
        new MainTest().publish(domainEventPublisher);
    }

    public void publish(DomainEventPublisher domainEventPublisher){
        domainEventPublisher.publishEvent(new ConnectEvent(this,"187.99.0.08"));
        domainEventPublisher.publishEvent(new ConnectEvent(this,"187.99.0.18"));
        domainEventPublisher.publishEvent(new ConnectEvent(this,"187.99.0.28"));
        domainEventPublisher.publishEvent(new ConnectEvent(this,"187.99.0.38"));
        domainEventPublisher.publishEvent(new ConnectEvent(this,"187.99.0.48"));
        domainEventPublisher.publishEvent(new ConnectEvent(this,"187.99.0.58"));

        domainEventPublisher.publishEvent(new RecievedDataEvent("hahah"));
    }

//    @Bean(name = AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME)
//    public SimpleApplicationEventMulticaster applicationEventMulticaster(){
//        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster(context);
//        simpleApplicationEventMulticaster.setTaskExecutor(executor);
//        return simpleApplicationEventMulticaster;
//    }


    @Bean(name = AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME)
    public AsyncableEventMulticaster applicationEventMulticaster(){
        AsyncableEventMulticaster asyncableEventMulticaster = new AsyncableEventMulticaster();
        return asyncableEventMulticaster;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
