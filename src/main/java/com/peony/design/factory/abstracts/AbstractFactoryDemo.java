package com.peony.design.factory.abstracts;

import com.peony.design.factory.abstracts.product.Keybo;
import com.peony.design.factory.abstracts.product.Mouse;

public class AbstractFactoryDemo {


    public static void main(String[] args) {
        PcFactory pcFactory = PcFactoryProducer.produce("asus");
        Mouse mouse = pcFactory.createMouse();
        Keybo keybo = pcFactory.createKeybo();
        PcFactory pcFactory1 = PcFactoryProducer.produce("dell");
        Mouse mouse1 = pcFactory1.createMouse();
        Keybo keybo1= pcFactory1.createKeybo();
        System.out.println(mouse1.source() +"\n"+ keybo1.source());
        System.out.println(mouse.source() +"\n"+ keybo.source());
    }
}
