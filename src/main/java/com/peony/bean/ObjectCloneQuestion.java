package com.peony.bean;

public class ObjectCloneQuestion {
    public static void main(String[] args) throws CloneNotSupportedException {
        ObjectCloneQuestion obj1 = new ObjectCloneQuestion();
        Object clone = obj1.clone();
        System.out.println(obj1 == clone);
    }
}
