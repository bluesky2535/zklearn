package com.zklearn.sort;

import java.util.Arrays;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.sort
 * @Author: zk
 * @CreateTime: 2021-12-02 16:21:41
 * @Description: 插入排序
 */
public class Insertion {

    public static void main(String[] args) {
        Integer[] a={6,10,8,4,9};
        insertionSort(a);
    }
    public static void insertionSort(Integer[] arr){

        //i为待插入的元素，与已经排序好的元素进行倒序遍历比较
        for (int i = 1; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr));
            for (int j = i; j > 0 ; j--) {
                if(greater(arr[j-1],arr[j]) ){
                    exchange(arr,j,j-1);
                }else{
                    break;
                }
            }
            System.out.println(Arrays.toString(arr));
            System.out.println("========================== ");
        }


    }



    public static boolean greater(Comparable x,Comparable y){
        return x.compareTo(y)>0 ;
    }

    public static void exchange(Comparable[] arr ,int i,int j){
        Comparable temp;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
