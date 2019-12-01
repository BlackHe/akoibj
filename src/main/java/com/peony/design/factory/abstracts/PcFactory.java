package com.peony.design.factory.abstracts;

import com.peony.design.factory.abstracts.product.Keybo;
import com.peony.design.factory.abstracts.product.Mouse;

public abstract class PcFactory {

    public abstract Mouse createMouse();

    public abstract Keybo createKeybo();
}
