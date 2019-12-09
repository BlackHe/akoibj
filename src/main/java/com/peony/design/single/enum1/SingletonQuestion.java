package com.peony.design.single.enum1;

public class SingletonQuestion {

    public static void main(String[] args) {
        SingletonEnum instance = SingletonEnum.INSTANCE;
        instance.say();
    }

    enum SingletonEnum{
        INSTANCE;

        public void say(){
            System.out.println("枚举实现的单例模式。。。");
        }
    }
}
