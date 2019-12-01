package com.peony.design.factory.abstracts;

import com.peony.design.factory.abstracts.product.DellKeybo;
import com.peony.design.factory.abstracts.product.DellMouse;
import com.peony.design.factory.abstracts.product.Keybo;
import com.peony.design.factory.abstracts.product.Mouse;

public class DellFactory extends PcFactory {
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public Keybo createKeybo() {
        return new DellKeybo();
    }
}
