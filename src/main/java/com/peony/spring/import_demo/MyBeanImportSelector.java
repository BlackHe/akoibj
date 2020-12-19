package com.peony.spring.import_demo;

import com.peony.spring.bean.OrderService;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyBeanImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{OrderService.class.getName()};
    }
}
