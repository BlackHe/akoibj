package com.peony.interview;

import static com.peony.utils.PrintUtils.*;


import java.util.Arrays;
import java.util.Random;

public class ArrayLengthQuestion {
    public static void main(String[] args) {
        int[] a;
        Random random = new Random();
        a = new int[random.nextInt(20)];
        println("length of a = " + a.length);
        println(Arrays.toString(a));

    }
}
