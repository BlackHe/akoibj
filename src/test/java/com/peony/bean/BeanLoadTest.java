package com.peony.bean;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * spring 从xml配置文件中加载，实例化java bean过程测试
 */

public class BeanLoadTest {


    @Test
    public void loadBeanFromXml(){
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationConfig.xml"));
        TestBean testBean = (TestBean) beanFactory.getBean("testBean");
        System.out.println(testBean);
    }

    @Test
    public void loadBeanFromXml1(){
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("test value={}",123456);
        ApplicationContext factory = new ClassPathXmlApplicationContext("applicationConfig.xml");
        TestBean testBean = (TestBean)factory.getBean("testBean");
        System.out.println(testBean.getCreateTime());

    }
}
