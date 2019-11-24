package com.peony.design.adapter01;

public class TFCardAdapter implements SDCard {
    private TFCard tfCard;

    public TFCardAdapter(TFCard tfCard){
        this.tfCard = tfCard;
    }

    @Override
    public String read() {
        return tfCard.read();
    }

    @Override
    public int write(String msg) {
        return tfCard.write(msg);
    }
}
