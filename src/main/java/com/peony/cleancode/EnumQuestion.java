package com.peony.cleancode;

public enum EnumQuestion {

    ONE {
        @Override
        public double rate() {
            return 1.0d;
        }
    },
    TWO {
        @Override
        public double rate() {
            return 2.0d;
        }
    };

    public abstract double rate();
}
