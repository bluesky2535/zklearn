package com.zklearn.linear;

import java.util.Iterator;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.linear
 * @Author: zk
 * @CreateTime: 2021-12-08 09:44:18
 * @Description: 队列
 */
public class Queue<T> implements Iterable<T>{

    public static void main(String[] args) {
        Queue<Integer> queue=new Queue<>();
        queue.enterQueue(10);
        queue.enterQueue(8);
        queue.enterQueue(99);
        queue.enterQueue(33);
        for (Integer integer : queue) {
            System.out.println(integer);
            System.out.println("===================================");
        }
        Integer res=queue.deleteQueue();
        System.out.println("取出队列值"+res);
        for (Integer integer : queue) {
            System.out.println(integer);
        }


    }

    private Node head;
    private Node last;
    private int N;

    public Queue() {
        this.head=new Node(null,null);
        this.last=null;
        this.N=0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }


    public void enterQueue(T t){
        if(last==null){
            last=new Node(t,null);
            head.next=last;
        }else{
            Node oldLast=last;
            last=new Node(t,null);
            oldLast.next=last;
        }
        N++;
    }

    public T deleteQueue(){
        if(isEmpty()){
            return null;
        }
        Node node=  head.next;
        head.next=head.next.next;
        N--;
        if(isEmpty()){
            last=null;
        }
        return node.item;
    }

    @Override
    public Iterator iterator() {
        return new QIterator();
    }

    public class QIterator implements Iterator{
        private Node n;
        public QIterator() {
            this.n = head;
        }
        @Override
        public boolean hasNext() {
            return n.next !=null;
        }
        @Override
        public Object next() {
            n=n.next;
            return  n.item;
        }
    }

    private class Node{
        //节点数据
        T item;
        //下一节点
        Node next;

        public Node(T item, Node next){
            this.item=item;
            this.next=next;
        }
    }

}
