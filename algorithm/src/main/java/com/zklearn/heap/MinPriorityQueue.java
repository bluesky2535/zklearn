package com.zklearn.heap;

public class MinPriorityQueue<T extends Comparable> {

    public static void main(String[] args) {
        MinPriorityQueue<String> queue=new MinPriorityQueue<>(20);
        queue.insert("Z");
        queue.insert("Y");
        queue.insert("X");
        queue.insert("W");
        queue.insert("V");
        queue.insert("U");

       while (!queue.isEmpty()){
           System.out.print( queue.deleteMin()+"-");
       }

    }


    private int N;
    private T[] queue;


    public int size(){
        return N;
    }
    public MinPriorityQueue(int capacity) {
        this.N=N;
        this.queue= (T[]) new Comparable[capacity + 1];
    }

    public static boolean less(Comparable[] heap, int i, int j){
        return heap[i].compareTo(heap[j])<0;
    }


    //交换位置
    public static void exchange(Comparable[] heap,int i,int j){
        Comparable temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }

    public  boolean isEmpty(){
        return N==0;
    }

    public void insert(T t){
        //在堆末尾添加元素
        queue[++N]=t;
        //进行元素上浮
        swim(N);
    }

    public  T deleteMin(){
        T res=queue[1];
        exchange(queue,1,N);
        queue[N]=null;
        N--;
        sink(1);
        return res;
    }

    public  void swim(int k){
        while (k>1){
            if(less(queue,k,k/2)){
                exchange(queue,k,k/2);
            }else{
                break;
            }
            k=k/2;
        }
    }

    public void sink(int k){
        while(2*k<=N){
            int min;
            if(2*k+1<=N){
                if (less(queue,2*k,2*k+1)) {
                    min=2*k;
                }else{
                    min=2*k+1;
                }
            }else{
                min=2*k;
            }

            if(less(queue,k,min)){
                break;
            }

            exchange(queue,min,k);
            k=min;
        }
    }
}
