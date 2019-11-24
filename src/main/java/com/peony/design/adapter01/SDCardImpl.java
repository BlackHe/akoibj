package com.peony.design.adapter01;

public class SDCardImpl implements SDCard {
    @Override
    public String read() {
        System.out.println("SDCard were readed....");
        return null;
    }

    @Override
    public int write(String msg) {
        System.out.println("SDCard were writed");
        return 0;
    }
}
