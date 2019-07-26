package com.peony.annotation.configuration;

import com.peony.annotation.bean.*;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 主配置类
 */

// 配置配申明
@Configuration
// 包扫描路径
//@ComponentScan("com.peony.annotation.configuration")
// 加载properties属性到环境变量
@PropertySource({"classpath:resource.properties"})
// 快速将一个bean注册到ioc
//@Import({Color.class,Red.class, MyImportSeletor.class,MyImportBeanDefinitionRegistrar.class})
// 开启事务管理
//@EnableTransactionManagement
public class MainConfig {


    // 交给IOC容器管理的bean
    @Bean(initMethod = "init", destroyMethod = "destory")
    @Scope("singleton")
    public Car car(){
        return new Car();
    }

    /**
     * FactoryBean的用法
     * @return
     */
    @Bean
    public DogFactroyBean dogFactroyBean(){
        return new DogFactroyBean();
    }

    @Bean
    public DataSource dataSource(){
        return new DataSource();
    }

    @Bean
    public Yellow yellow(){
        return new Yellow();
    }


}
