package com.peony.sort;

/**
 * 快速排序
 */
public class QuickSortQuestion {

    public static void main(String[] args) {
        int[] a = {9, 1000, 10, -9, 2, 33};
        quickSort(a, 0, a.length - 1);
        MaoPaoSortQuestion.printArray(a);
    }

    /**
     * 分治思想
     *
     * @param array
     */
    public static void quickSort(int[] array, int low, int high) {
        // 递归的出口
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int key = array[low];

        while (i < j) {
            // 从右往左找第一个大于key的数
            while (i < j && array[j] > key) {
                j--;
            }
            // 从左往右找第一个小于key的数
            while (i < j && array[i] <= key) {
                i++;
            }
            // 交换
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // 调整key的位置
        int p = array[i];
        array[i] = array[low];
        array[low] = p;
        // 对key左边的数进行排序
        quickSort(array, low, i - 1);
        // 对key有变动额数进行排序
        quickSort(array, i + 1, high);
    }
}
