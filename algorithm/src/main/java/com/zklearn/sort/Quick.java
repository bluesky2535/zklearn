package com.zklearn.sort;

import java.util.Arrays;

public class Quick {

    public static void main(String[] args) {
        Integer[] arr = {10, 9, 8, 7, 4, 3, 2, 1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(Integer[] arr) {
        int low = 0;
        int high = arr.length - 1;
        sort(arr, low, high);
    }

    public static boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    public static void sort(Comparable[] arr, int low, int high) {
        if (high <= low) {
            return;
        }
        int partition = partition(arr, low, high);
        //左边进行排序
        sort(arr, low, partition - 1);
        //右边进行排序
        sort(arr, partition + 1, high);

    }

    private static int partition(Comparable[] arr, int low, int high) {
        int left = low;
        int right = high + 1;
        Comparable key = arr[low];

        while (true) {
            //将右指针向左遍历，当遇到小于key值时，则停止
            while (less(key, arr[--right])) {
                if (right == low) {
                    break;
                }
            }
            //将左指针向右遍历，当遇到大于key值时，则停止
            while (less(arr[++left], key)) {
                if (left == high) {
                    break;
                }
            }
            if (left >= right) {
                break;
            } else {
                exchange(arr, left, right);
            }
        }
        exchange(arr, low, right);
        return right;
    }


    public static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
