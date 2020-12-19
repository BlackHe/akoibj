package com.peony.spring.import_demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MyBeanImportSelector.class)
public class BeanConfiguration {


}
