package com.peony.sourcecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class HashMapCode {

    public static void main(String[] args) {
        final String[] arr = {"1", "2", "as", "d", "2d", "d2", "ds", "ads", "3fs", "sljk", "as2", "lk", "osl", "pso", "ps", "ppp"};
        ArrayList<String> strings = new ArrayList<>(Arrays.asList("1", "2", "as", "d", "2d", "d2", "ds", "ads", "3fs", "sljk"));
        Map<String, Integer> map = new HashMap<>();
        strings.forEach((item) -> map.put(item, ThreadLocalRandom.current().nextInt(100)));
        Integer s = map.get("2");
    }
}
