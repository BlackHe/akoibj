package com.peony.classload;

public class ClassForNameAndClassLoaderCompare {

    public static void main(String[] args) {
        classLoad();
    }

    public static void classForName(){
        try{
            Class<?> aClass = Class.forName("com.peony.classload.ClassForNameBean");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void classLoad(){
        try{
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Class<?> aClass = classLoader.loadClass("com.peony.classload.ClassForNameBean");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }


    }
}
