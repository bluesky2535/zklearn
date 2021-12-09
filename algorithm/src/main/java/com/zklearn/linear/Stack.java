package com.zklearn.linear;

import java.util.Iterator;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.linear
 * @Author: zk
 * @CreateTime: 2021-12-07 17:06:48
 * @Description: 栈
 */
public class Stack<T> implements Iterable<T>{


    public static void main(String[] args) {

        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        for (Integer integer : stack) {
            System.out.println(integer);
        }

        //测试弹栈
        Integer pop = stack.pop();
        System.out.println("弹出元素"+pop);
        System.out.println("栈大小"+stack.size());

    }

    private Node head;
    private int N;

    public Stack() {
        this.head=new Node(null,null);
        this.N=0;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }


    public void push(T t){
        Node temp=head.next;
        Node newNode =new Node(t,temp);
        head.next=newNode;
        N++;
    }

    public T pop(){
        Node result=head.next;
        if(result==null){
            return null;
        }
        head.next=result.next;
        N--;
        return result.item;
    }

    @Override
    public Iterator iterator() {
        return new SIterator();
    }

    public class SIterator implements Iterator{
        private Node n;
        public SIterator() {
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
