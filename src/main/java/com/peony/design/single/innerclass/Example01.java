package com.peony.design.single.innerclass;

public class Example01 {

    private Example01(){
        System.out.println("single class instance...");
    };

    public static void main(String[] args) {
        Example01 single1 = getSingle();
        Example01 single2 = getSingle();
        Example01 single3 = getSingle();
        System.out.println(single1);
        System.out.println(single2);
        System.out.println(single3);
    }

    static class SinglerHolder{
       private static Example01 SINGLE = new Example01();
    }

    public static Example01 getSingle(){

        // 使用到内部类属性的时候，才会进行内部类的类加载，
        // 并且列加载过程天生就是线程安全的
        return SinglerHolder.SINGLE;
//        如果没有使用到内部类的额属性，内部类就不会进行类加载过程，实现了懒加载功能
//        return null;
    }
}
