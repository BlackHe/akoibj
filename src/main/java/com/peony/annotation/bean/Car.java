package com.peony.annotation.bean;

import lombok.Data;

@Data
public class Car {

    public Car() {
        this.name = "black";
        System.out.println("car construct run .....");
    }

    public void init() {
        System.out.println("car.init() is run...");
    }


    public void destory() {
        System.out.println("car.destory is run .....");
    }

    private String name;
}
