package com.peony.design.adapter01;

public class ThinkPadComputer implements Computer {
    private SDCard sdCard;

    public ThinkPadComputer(SDCard sdCard) {
        this.sdCard = sdCard;
    }


    @Override
    public String read(String type) {
        return sdCard.read();
    }
}
