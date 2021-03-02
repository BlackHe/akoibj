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

    private static Thread t1 = null;
    private static Thread t2 = null;
    private static Thread t3 = null;

    public static void main(String[] args) throws InterruptedException {


        Method[] methods = MainTest2.class.getMethods();
        for (Method method : methods) {
            if (!method.getName().equals("sixSix")){
                continue;
            }
            Method six = method;
            ParameterizedTypeImpl genericReturnType = (ParameterizedTypeImpl)six.getGenericReturnType();
            Type[] actualTypeArguments = genericReturnType.getActualTypeArguments();

            for (Type typeArgument : actualTypeArguments) {
                System.out.println(typeArgument);
            }
        }


    }

    public Map<String,Object> sixSix(Map<Long,Integer> param){
        return new HashMap<>();
    }


}
