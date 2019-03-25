package com.peony.annotation_dev.configuration.config_bean;

import lombok.Data;

@Data
public class Car {

    public Car() {
        this.name = "black";
        System.out.println("car construct run .....");
    }

    public void init(){
        System.out.println("car.init() is run...");
    }


    public void destory(){
        System.out.println("car.destory is run .....");
    }

    private String name;
}
