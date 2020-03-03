package com.peony.algorithm;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个数组，和一个整数，
 * 请找到改数组中两个元素的和为该整数的索引
 */
public class TwoNumberSumQuestion {

    public static void main(String[] args) {
        int[] arr = {3, 0, 29, 8, -7, 7, 2};
        int target = 0;
        int[] s1 = sum(arr, target);
        printArr(s1);
        int[] s2 = sumByHash(arr, target);
        printArr(s2);
    }

    public static int[] sum(int[] array, int n) {
        int[] indexs = new int[2];
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (i != j && (array[i] + array[j]) == n) {
                    indexs[0] = i;
                    indexs[1] = j;
                    return indexs;
                }
            }
        }
        return indexs;
    }

    public static int[] sumByHash(int[] array, int target) {
        int[] indexs = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>(array.length);
        for (int i = 0; i < array.length; ++i) {
            if (hashMap.containsKey(array[i])) {
                indexs[0] = i;
                indexs[1] = hashMap.get(array[i]);
                return indexs;
            } else {
                hashMap.put(target - array[i], i);
            }
        }
        return indexs;

    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }
    }
}
