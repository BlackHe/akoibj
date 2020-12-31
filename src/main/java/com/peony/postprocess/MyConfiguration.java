package com.peony.postprocess;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MyService.class,MyBeanPostProcessor.class})
@ComponentScan
public class MyConfiguration {


}
