package com.peony.annotation_dev.configuration;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSeletor implements ImportSelector {

    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.peony.annotation_dev.configuration.config_bean.Yellow","com.peony.annotation_dev.configuration.config_bean.Blue"};
    }
}
