package com.peony.reflect;

import com.sun.org.apache.regexp.internal.RE;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

/**
 * 通过Class对象，获取到类的构造器，再用构造器生成实例
 */
public class ClassConstructQuestion {

    public ClassConstructQuestion() {
        System.out.printf("hello world");
    }

    public ClassConstructQuestion(String name) {
        System.out.printf(name);
    }


    public static void main(String[] args) {
        ClassConstructQuestion instance = instanceBuilder(ClassConstructQuestion.class);
        System.out.printf(instance.toString());
    }

    public static <T> T instanceBuilder(Class<T> tClass){
        if (tClass == null){
            return null;
        }
        T instance = null;
        Constructor<?>[] constructors = tClass.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            Constructor constructor = constructors[i];
            constructor.setAccessible(true);
            Parameter[] parameters = constructor.getParameters();
            for (int j = 0; j < parameters.length; j++) {
                Class<?> type = parameters[j].getType();
                if (type.equals(String.class)){
                    String paramName = parameters[j].getName();
                    System.out.printf("paramName=[%s]",paramName);
                }
            }
        }
        return null;
    }
}
