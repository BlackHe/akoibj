package com.peony.objclass;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

public class ObjectLyout {
   static Object o = null;

    public static void main(String[] args) {
        o = new Object();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());


        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
