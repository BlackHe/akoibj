package com.peony.sort;

/**
 * 快速排序算法
 */
public class QuickSort2Question {

    public static void main(String[] args) {
        int[] arr = {10, -999, 2, 0, 29932, -1};
        printArr(arr);
        quickSort(arr, 0, arr.length -1);
        printArr(arr);
    }

    public static void quickSort(int[] array, int left, int right){
        int length = array.length;
        // 参数校验
        if (array == null || length == 0 || length == 1){
            return;
        }
        // 递归出口
        if (left > right){
            return;
        }
        int i = left, j = right, key = array[i];
        while (i != j){
            // 从右往左找,直到找出比key小的数
            while(i < j && array[j] >= key){
                j--;
            }
            // 从左往右找,直到找出比key大的数字
            while (i < j && array[i] <= key){
                i++;
            }
            // i 和 j所在的元素交换位置
            if (i < j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        array[left] = array[i];
        array[i] = key;

        // 递归排序左边序列
        quickSort(array,left,i - 1);
        // 递归排序右边的序列
        quickSort(array,i + 1, right);
    }

    public static void printArr(int [] array){
        for (int i = 0; i < array.length; ++i){
            System.out.print(array[i]+"\t");
        }
        System.out.println();
    }
}
