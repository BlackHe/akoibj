package com.peony.annotation_dev.configuration.config_bean;

import org.springframework.beans.factory.FactoryBean;

public class DogFactroyBean implements FactoryBean<Dog> {
    public Dog getObject() throws Exception {
        return new Dog();
    }

    public Class<?> getObjectType() {
        return Dog.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
