package com.peony.design.adapter01;

public class AdapterDemo {

    public static void main(String[] args) {
        Computer computer = new ThinkPadComputer(new SDCardImpl());
//        Computer computer = new ThinkPadComputer(new TFCardImpl());
        Computer computer1 = new ThinkPadComputer(new TFCardAdapter(new TFCardImpl()));
        String read = computer1.read(ReadType.SD.toString());
    }





    enum ReadType{
        SD,
        TF
    }
}
