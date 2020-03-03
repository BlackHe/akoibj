package com.peony.sort;

/**
 * 快速排序
 * 时间复杂度：O(nlogn)
 */
public class QuickSort3Question {

    public static void main(String[] args) {
        int[] array = {1, 9, 0, 2, 7};
        printArr(array);
        quickSort(array, 0, array.length - 1);
        printArr(array);
    }

    public static void quickSort(int[] array, int low, int high) {
        if (array == null || array.length == 0 || array.length == 1) {
            return;
        }
        if (low > high) {
            return;
        }
        int i = low, j = high, key = array[i];
        while (i != j) {
            while (i < j && array[j] >= key) {
                j--;
            }
            while (i < j && array[i] <= key) {
                i++;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[low] = array[i];
        array[i] = key;
        quickSort(array, low, i - 1);
        quickSort(array, i + 1, high);
    }

    public static void printArr(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}
