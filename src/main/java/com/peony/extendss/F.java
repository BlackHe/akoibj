package com.peony.extendss;

import java.io.*;
import java.lang.annotation.*;

public class F {

    private int x;

    private static int y;


    {
        x=1;
        y=2;
    }

    static {
        y=1;
    }

    public static void main(String[] args) throws Exception{

        SuperClass obj = new SuperClass();
        System.out.println(obj);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\testObjSerial"));
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();


        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\testObjSerial"));
        SuperClass o = (SuperClass)objectInputStream.readObject();
        System.out.println(o);
        System.out.println(o.a);

        System.out.println(obj == o);

        Object clone = obj.clone();
        System.out.println(obj == clone);


    }





    @Mock
    static class SuperClass implements Serializable,Cloneable {
        public static final long serialVersionUID = 8293823923L;
        private String a = "hello serialize";

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    @Mock
    static class ChildClass extends SuperClass{
        public static final long serialVersionUID = 8293823923L;
        private String b = "666";
    }

    @Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Inherited
    @interface Mock{

        String value() default "no";
    }
}
