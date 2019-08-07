package com.peony.math;

import java.math.BigDecimal;

public class Math {

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(2.9999932);
//        BigDecimal a = BigDecimal.ZERO;
        BigDecimal b = a.setScale(2, BigDecimal.ROUND_DOWN);
        System.out.println(b);
    }
}
