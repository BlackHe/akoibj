package com.peony.annotation_dev;

import com.peony.annotation_dev.configuration.MainConfig;
import com.peony.annotation_dev.configuration.config_bean.Car;
import com.peony.annotation_dev.configuration.config_bean.DataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class Test01 {


    @Test
    public void testBean(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames ) {
            System.out.println(name);
        }
        DataSource bean = context.getBean(DataSource.class);
        System.out.println(bean.toString());


    }
}
