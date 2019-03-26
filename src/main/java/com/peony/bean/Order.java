package com.peony.bean;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@Component
public final class Order {

    @Autowired
    private Report report;

    @PreDestroy
    public void destory(){
        System.out.println("I'm die....");
    }

    @PostConstruct
    public void init(){
        System.out.println("I'm brith.........");
    }
}
