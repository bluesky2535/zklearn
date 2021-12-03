package com.zklearn.sort;

import java.util.Arrays;

public class Merge {

    static Comparable[] assist;
    public static void main(String[] args) {
        Integer[] arr={10,9,8,7,4,3,2,1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(Integer[] arr){
        assist=new Comparable[arr.length];
        int low=0;
        int high=arr.length-1;
        sort(arr,low,high);
    }

    public static boolean less(Comparable x,Comparable y){
        return x.compareTo(y)<0 ;
    }

    public static void sort(Comparable[] arr ,int low,int high){
        if(high<=low){
            return;
        }
        //拆分为两个组
        int mid=low+(high-low)/2;

        //左边进行排序
        sort(arr,low,mid);
        //右边进行排序
        sort(arr,mid+1,high);
        System.out.println(Arrays.toString(arr));
        System.out.println(low +" "+mid+" "+ high);

        //进行合并
        merge(arr,low,mid,high);

        System.out.println("轮次"+Arrays.toString(arr));
        System.out.println("=============================");

    }

    private static void merge(Comparable[] arr, int low,int mid, int high) {
        //有三个指针
        int index=low;
        int p1=low;
        int p2=mid+1;

        //将两个分组的指针遍历比较
        while(p1<=mid && p2 <=high){
            if(less(arr[p1],arr[p2])){
                assist[index++]=arr[p1++];
            }else{
                assist[index++]=arr[p2++];
            }
        }
        //当p1指针未走完，则遍历走完
        while(p1<=mid){
            assist[index++]=arr[p1++];
        }
        //当p2指针未走完，则遍历走完
        while(p2<=high){
            assist[index++]=arr[p2++];
        }
        //将assist数组复制到原数组
        for (int i = low; i <= high; i++) {
            arr[i]=assist[i];
        }
    }



}
