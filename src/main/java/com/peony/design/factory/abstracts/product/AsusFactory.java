package com.peony.design.factory.abstracts.product;

import com.peony.design.factory.abstracts.PcFactory;
import com.peony.design.factory.abstracts.PcFactoryProducer;

public class AsusFactory extends PcFactory {
    @Override
    public Mouse createMouse() {
        return new AsusMouse();
    }

    @Override
    public Keybo createKeybo() {
        return new AsusKeybo();
    }
}
