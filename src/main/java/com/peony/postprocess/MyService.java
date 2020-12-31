package com.peony.postprocess;


import org.springframework.transaction.annotation.Transactional;

public class MyService {

    public MyService() {
        System.out.println("myService instanin......");
    }

    @Transactional
    public void update(){

    }
}
