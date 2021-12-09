package com.zklearn.linear;

import java.util.Iterator;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.linear
 * @Author: zk
 * @CreateTime: 2021-12-06 16:18:58
 * @Description: 双向链表
 */
public class TwoWayLinkList<T>  implements Iterable<T> {



    public static void main(String[] args) {
        TwoWayLinkList<Integer> linkList=new TwoWayLinkList<>();
        linkList.insert(10);
        linkList.insert(23);
        linkList.insert(45);

        for (Integer o : linkList) {
            System.out.println(o);
        }
        System.out.println("===================================");

        //获取相应索引的值
        Integer integer = linkList.get(2);
        System.out.println("索引"+integer);
        System.out.println("===================================");

        //删除对应索引的元素
        Integer remove = linkList.remove(1);
        System.out.println("删除的元素为"+remove);
        for (Integer o : linkList) {
            System.out.println(o);
        }

        System.out.println("===================================");

        //清空链表
        linkList.clear();
        for (Integer o : linkList) {
            System.out.println(o);
        }

        System.out.println("第一个元素"+linkList.getLast());
        System.out.println("最后一个元素"+linkList.getFirst());



    }

    private class Node{
        //节点数据
        T item;
        //上一节点
        Node pre;
        //下一节点
        Node next;

        public Node(T item,Node pre,Node next){
            this.item=item;
            this.pre=pre;
            this.next=next;
        }
    }

    private Node head;
    private Node last;
    private int N;


    public TwoWayLinkList() {
        //初始化头节点，不存储数据
        this.head=new Node(null,null,null);
        this.N=0;
    }

    public void clear(){
        this.head.next=null;
        this.head.pre=null;
        this.head.item=null;
        this.last=null;
        this.N=0;
    }

    public boolean isEmpty(){
        return N==0;
    }


    public int length(){

        return N;
    }


    //获取第一个元素
    public T getFirst(){

        if(isEmpty()){
            return  null;
        }
        return head.next.item;
    }

    //获取最后一个元素
    public T getLast(){
        if(isEmpty()){
            return null;
        }
        return last.next.item;
    }



    public void insert(T t){
        if(isEmpty()){
            Node newNode=new Node(t,head,null);
            head.next=newNode;
            last=newNode;
        }else{
            Node oldLast=last;
            Node newNode=new Node(t,oldLast,null);
            oldLast.next=newNode;
            last=newNode;
        }
        N++;
    }

    public void insert(int i,T t){
        Node n=head;
        //找到i位置的前一个节点
        for (int j = 0; j <= i-1; j++) {
            n=n.next;
        }
        //这是当前i节点的值
        Node temp=n.next;
        Node newNode=new Node(t,n,temp);
        n.next=newNode;
        temp.pre=newNode;
        N++;
    }


    public T get(int i){

        Node n=head;
        for (int j = 0; j <=i ; j++) {
            n=n.next;
        }
        return n.item;
    }


    public T remove(int i){
        Node n=head;
        //找到i位置的前一个节点
        for (int j = 0; j <= i-1; j++) {
            n=n.next;
        }
        //找到i位置的节点
        Node curr=n.next;
        //i位置的下一个节点
        Node nextNode=curr.next;
        //前一个节点指向下一个节点
        n.next=nextNode;
        nextNode.pre=n;
        N--;
        return curr.item;
    }

    public int indexOf(T t){
        Node n=head;
        //找到i位置的前一个节点
        for (int j = 0; j < N; j++) {
            n=n.next;
            if(n.item.equals(t)){
                return j;
            }
        }
        return -1;
    }



    @Override
    public Iterator<T> iterator() {
        return new TLIterator();
    }

    private class TLIterator implements Iterator{

        private Node n;

        public TLIterator() {
            this.n=head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public T next() {
            n=n.next;
            return n.item;
        }
    }

}
