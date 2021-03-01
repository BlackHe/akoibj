package com.peony.spring.config_parse_source_code;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.*;
import org.springframework.context.event.EventListener;
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


    public class Man implements InitializingBean, BeanPostProcessor {
        int age = 40;

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println("initializingBean.afterPropertiesSet");
        }

        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("before Initialization bean:"+bean + " beanName:"+beanName);
            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            System.out.println("after Initialization bean:"+bean + " beanName:"+beanName);
            return bean;
        }
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
