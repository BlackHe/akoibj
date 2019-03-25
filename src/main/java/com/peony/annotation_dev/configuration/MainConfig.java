package com.peony.annotation_dev.configuration;

import com.peony.annotation_dev.configuration.config_bean.*;
import org.springframework.context.annotation.*;

/**
 * 主配置类
 */

// 配置配申明
@Configuration

// 包扫描路径
@ComponentScan("com.peony.annotation_dev")

@PropertySource({"classpath:resource.properties"})
// 快速将一个bean注册到ioc
@Import({Color.class,Red.class, MyImportSeletor.class,MyImportBeanDefinitionRegistrar.class})
public class MainConfig {


    // 交给IOC容器管理的bean
    @Bean(initMethod = "init", destroyMethod = "destory")
    @Scope("singleton")
    public Car car(){
        return new Car();
    }

    @Bean
    public DogFactroyBean dogFactroyBean(){
        return new DogFactroyBean();
    }

    @Bean
    public DataSource dataSource(){
        return new DataSource();
    }

}
