package com.peony.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.寻址算法是怎么实现的
 * 2.扩容的逻辑
 * 3.转树的逻辑
 */
public class HashMapQuestion {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        /*
        "id" ->         h = hashcode=3355  bin=  1101 0001 1011
        h               0000 0000 0000 0000 0000 1101 0001 1011
        h>>>16 =        0000 0000 0000 0000 0000 0000 0000 0000

        m = h ^ h>>>16 =0000 0000 0000 0000 0000 1101 0001 1011

        n = size-1 =    0000 0000 0000 0000 0000 0000 0000 1111
        index=m&(n-1) = 0000 0000 0000 0000 0000 0000 0000 1011  = 11
         */
        map.put("id", "20");

    }
}
