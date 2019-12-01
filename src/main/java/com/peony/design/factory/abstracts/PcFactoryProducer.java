package com.peony.design.factory.abstracts;

import com.peony.design.factory.abstracts.product.AsusFactory;

public class PcFactoryProducer {

    public static  PcFactory produce(String source){
        if ("hp".equalsIgnoreCase(source)){
            return new HpFactory();
        }else if ("dell".equalsIgnoreCase(source)){
            return new DellFactory();
        }else if ("asus".equalsIgnoreCase(source)){
            return new AsusFactory();
        }else {
            return null;
        }
    }
}
