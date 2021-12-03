package com.zklearn.sort;

import java.util.Arrays;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.sort
 * @Author: zk
 * @CreateTime: 2021-12-02 17:13:47
 * @Description: 希尔排序
 */
public class Shell {
    public static void main(String[] args) {
        Integer[] a = {6, 10, 8, 4, 9};
        shellSort(a);
    }

    /**
     * 这是冒泡函数
     *
     * @param arr 传入int数组
     */
    private static void shellSort(Integer[] arr) {

        //1.根据数组的长度，获取相应的增长量
        int h = 1;
        while (h < arr.length / 2) {
            h = 2 * h + 1;
        }
        //2.进行希尔排序
        while (h >= 1) {
            System.out.println(Arrays.toString(arr));
            //2.1 找出首先需要插入的元素
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (greater(arr[j - h], arr[j])) {
                        exchange(arr, j - h, j);
                    } else {
                        break;
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
            System.out.println("========================== ");
            //3.缩小增量
            h = h / 2;
        }
    }

    public static boolean greater(Comparable x, Comparable y) {
        return x.compareTo(y) > 0;
    }

    public static void exchange(Comparable[] arr, int i, int j) {
        Comparable temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
