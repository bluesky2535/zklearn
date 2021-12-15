package com.zklearn.heap;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn
 * @Author: zk
 * @CreateTime: 2021-12-10 11:06:50
 * @Description: 堆
 */
public class Heap<T extends Comparable<T>> {

    public static void main(String[] args) {

        Heap<String> heap=new Heap<>(10);
        heap.insert("A");
        heap.insert("B");
        heap.insert("C");
        heap.insert("D");
        heap.insert("E");
        heap.insert("F");
        heap.insert("G");

        String result=null;
        while ((result=heap.deleteMax())!=null){
            System.out.println(result);
        }


    }


    private T[] items;
    private int N;

    public Heap(int capacity) {
        items= (T[]) new Comparable[capacity+1];
        this.N=0;
    }

    private boolean less(int i,int j){
        return items[i].compareTo(items[j])<0;
    }

    private void exchange(int i,int j){
        T tmp=items[i];
        items[i]=items[j];
        items[j]=tmp;

    }

    public void insert(T t){
        items[++N]=t;
        swim(N);
    }


    public T deleteMax(){
        T max=items[1];
        items[1]=items[N];
        items[N]=null;
        N--;
        sink(1);
        return max;
    }


    public void swim(int k){
        while (k>1){
            if(less(k/2,k)){
                exchange(k,k/2);
            }
            k=k/2;
        }
    }
    public void sink(int k){
          while(2*k<=N){
              //获取左右子节点中最大值对应的索引
              int max;
              if(2*k+1<=N){
                  if(less(2*k,2*k+1)){
                    max=2*k+1;
                  }else{
                      max=2*k;
                  }
              }else{
                  max=2*k;
              }
              //比较当前节点和较大节点的值
              //如果小于k节点的值都大于左右子节点的值
              if(less(max,k)){
                break;
              }
              //交换k和子节点的值，即下沉
              exchange(max,k);
              //变换k值，继续下沉循环判断
              k=max;
          }
    }

}
