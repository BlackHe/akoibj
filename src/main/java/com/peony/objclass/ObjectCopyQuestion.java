package com.peony.objclass;

import java.util.HashMap;

/**
 * 深拷贝
 * 浅拷贝
 */
public class ObjectCopyQuestion implements Cloneable{



    private int age = 0;
    private HashMap<String,String> cache = new HashMap<>();

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (obj instanceof ObjectCopyQuestion ){
            ObjectCopyQuestion var = (ObjectCopyQuestion) obj;
            if (this.age == var.age){
                return true;
            }

        }
        return false;
    }



    public static void main(String[] args) throws CloneNotSupportedException{
        ObjectCopyQuestion obj = new ObjectCopyQuestion();
        Object clone = obj.clone();
        System.out.println(obj == clone);
        System.out.println(obj.equals(clone));
    }
}
