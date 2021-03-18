package com.peony;


import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;

public class MainTest2 {


    private int a = 's' ;

    public static void main(String[] args) throws InterruptedException {

        System.out.println(0xa == 10);

        MainTest2 obj = new MainTest2();
        System.out.println(obj.a);
        System.out.println(obj.a);
        obj.exec(obj::defaultCallback);
        System.out.println(obj.a);


    }


    public void exec(Callbacker callbacker) {
        System.out.println("666");
        callbacker.callback();
        System.out.println("777");
    }


    interface Callbacker {
        void callback();
    }

    public void defaultCallback(){
        this.a = 199;
        System.out.println("default callback...");
    }
}
