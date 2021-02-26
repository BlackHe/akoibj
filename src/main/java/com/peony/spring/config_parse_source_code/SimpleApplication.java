package com.peony.spring.config_parse_source_code;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.*;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.io.DefaultResourceLoader;

@Configuration
@PropertySource("classpath:resource.properties")
@ImportResource
public class SimpleApplication {

    public static void main(String[] args) {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SimpleApplication.class);
        int beanDefinitionCount = context.getBeanDefinitionCount();
        System.out.println(beanDefinitionCount);

        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        resourceLoader.getResource("/aasa");
    }


    @Bean
    public Man man(){
        return new Man();
    }


    public class Man{
        int age = 40;
    }

    public class SimpleDomainEvent extends ApplicationEvent {

        private String eventMsg;

        /**
         * Create a new ApplicationEvent.
         *
         * @param source the object on which the event initially occurred (never {@code null})
         */
        public SimpleDomainEvent(Object source) {
            super(source);
        }
    }

    @EventListener(SimpleDomainEvent.class)
    public void onWrite(SimpleDomainEvent event){
        System.out.println(event.eventMsg);
    }
}
