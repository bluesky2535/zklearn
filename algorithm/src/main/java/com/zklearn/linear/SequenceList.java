package com.zklearn.linear;

import java.util.Iterator;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: PACKAGE_NAME
 * @Author: zk
 * @CreateTime: 2021-12-06 08:38:19
 * @Description: 线性表
 */
public class SequenceList<T>  implements Iterable<T>{

    public static void main(String[] args) {
        SequenceList<Integer> sequenceList=new SequenceList<>(3);
        sequenceList.insert(10);
        sequenceList.insert(23);
        sequenceList.insert(45);

        for (Integer integer : sequenceList) {
            System.out.println(integer);
        }

    }


    private T[] eles;

    //线性表的长度
    private int N;

    public SequenceList(int capacity) {
        this.eles=(T[])new Object[capacity];
        this.N=0;
    }

    //判断线性表是否为空
    public boolean isEmpty(){
        return N==0;
    }


    //返回线性表的长度
    public int  length(){
        return N;
    }


    //向相应索引插入相应的值
    public void insert(int i,T t){
        if(N==eles.length){
            resize(2*eles.length);
        }
        for(int index=N;index>i;index--){
            eles[index]=eles[index-1];
        }
        eles[i]=t;
    }

    //向线性表中插入值
    public void insert(T t){
        if(N==eles.length){
            resize(2*eles.length);
        }
        eles[N++]=t;
    }

    //删除相应索引的值
    public T remove(int i){


        T current =eles[i];
        for (int j = i; j < N-1; j++) {
            eles[j] = eles[j+1];
        }
        //元素个数减1
        N--;

        if(N < eles.length/4){
            resize(eles.length/2);
        }

        return current;
    }

    //清空线性表
    public void clear(){
        this.N=0;
    }

    //获取相应索引对应的值
    public T get(int i){
        return eles[i];
    }

    //查找相应元素对应的索引
    public int indexOf(T t){
        for (int i = 0; i < N; i++) {
            if(eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }


    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }


    private class SIterator implements Iterator{
        private int cursor;

        public SIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor<N;
        }

        @Override
        public Object next() {
            return eles[cursor++];
        }
    }

    //缩容或扩容
    private void resize(int size){
        T[] temp=eles;
        eles=(T[]) new Object[size];
        for (int i = 0; i < eles.length; i++) {
            eles[i]=temp[i];
        }
    }
}
