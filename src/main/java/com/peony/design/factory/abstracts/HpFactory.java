package com.peony.design.factory.abstracts;

import com.peony.design.factory.abstracts.product.HpKeybo;
import com.peony.design.factory.abstracts.product.HpMouse;
import com.peony.design.factory.abstracts.product.Keybo;
import com.peony.design.factory.abstracts.product.Mouse;

public class HpFactory extends PcFactory {
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public Keybo createKeybo() {
        return new HpKeybo();
    }
}
