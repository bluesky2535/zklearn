package com.zklearn.heap;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        String[] source=new String[]{"Z","F","X","Y","U","W","N","K","M","G"};
        HeapSort.sort(source);
        System.out.println(Arrays.toString(source));
    }


    //交换位置
    public static void exchange(Comparable[] heap,int i,int j){
        Comparable temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }


    //比较大小
    public static  boolean less(Comparable[] heap,int i,int j){
        return heap[i].compareTo(heap[j])<0;
    }



    public static void  sort(Comparable[] source){
        Comparable[] heap=new Comparable[source.length+1];
        createHeap(source,heap);
        //定义未排序元素中最大的索引
        int N=heap.length-1;
        for (int i = heap.length-1; i > 1 ; i--) {
            //最大元素索引处与未排序的最大索引进行交换
            exchange(heap,1,N);
            //排序交换后最大元素的索引，让其不要参与下沉调整
            N--;
            sink(heap,1,N);
        }
        System.arraycopy(heap,1,source,0,source.length);
    }

    public static void createHeap(Comparable[] source,Comparable[] heap){
        //把source拷贝到heap堆中
        System.arraycopy(source,0,heap,1,source.length);
        //对堆中的元素做下沉调整，并从长度的一半处进行调整
        for (int i = heap.length/2; i > 0 ; i--) {
            sink(heap,i,heap.length-1);
        }

    }

    public static void sink(Comparable[] heap,int target,int range){
        while(2*target<=range){
            //找出当前节点的较大子节点
            int max;
            if(2*target+1<=range){
                if(less(heap,2*target,2*target+1)){
                    max=2*target+1;
                }else{
                    max=2*target;
                }

            }else{
                max=2*target;
            }

            if(less(heap,max,target)){
                break;
            }
            exchange(heap,max,target);

            target=max;
        }


    }



}
