package com.peony.design.adapter01;

public class TFCardImpl implements TFCard {
    @Override
    public String read() {
        System.out.println("TFCard were readed.....");
        return null;
    }

    @Override
    public int write(String msg) {
        System.out.println("TFCard were writed.....");
        return 0;
    }
}
