package com.peony.classload;

public class ClassLoadBean {

    static {
        System.out.println("I'm inited by Class.forName() ");
    }
}
