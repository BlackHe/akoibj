package com.peony.sort;

public class MaoPaoSortQuestion {

    public static void main(String[] args) {
        int[] ints = {-9, 100, 1, 4, 12522};
        sortByMaoPao(ints);
        printArray(ints);
    }

    public static void sortByMaoPao(int[] array) {
        if (paramValidate(array)) return;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j) {
                    continue;
                }
                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    private static boolean paramValidate(int[] array) {
        if (array == null || array.length == 0) {
            return true;
        }
        return false;
    }

    public static void printArray(int[] array) {
        if (paramValidate(array)) return;
        for (int a : array) {
            System.out.println(a);
        }
    }
}
