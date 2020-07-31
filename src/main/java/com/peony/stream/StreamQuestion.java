package com.peony.stream;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StreamQuestion {

    public static void main(String[] args) {
        Map<String,BigDecimal> map = new HashMap<String,BigDecimal>(){{
            put("BTC",new BigDecimal("10.99"));
            put("ETH",new BigDecimal("1.001"));
            put("USDT",new BigDecimal("0.22"));
        }};
        BigDecimal sum = map.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sum);
    }
}
