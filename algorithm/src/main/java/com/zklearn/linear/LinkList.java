package com.zklearn.linear;

import java.util.Iterator;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.linear
 * @Author: zk
 * @CreateTime: 2021-12-06 10:32:19
 * @Description: 链表
 */
public class LinkList<T>  implements Iterable<T> {


    public static void main(String[] args) {
        LinkList<Integer> linkList=new LinkList<>();
        linkList.insert(10);
        linkList.insert(23);
        linkList.insert(45);
        linkList.insert(55);
        linkList.insert(69);
        linkList.insert(78);

        for (Integer o : linkList) {
            System.out.println(o);
        }
        System.out.println("========反转链表===========================");

        //反转链表
        linkList.reverse();

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


    }

    private class Node{
        //节点数据
        T item;
        //下一节点
        Node next;

        public Node(T item,Node next){
            this.item=item;
            this.next=next;
        }
    }

    private Node head;
    private int N;


    public LinkList() {
        //初始化头节点，不存储数据
        this.head=new Node(null,null);
        this.N=0;
    }

    public void clear(){
        head.next=null;
    }

    public boolean isEmpty(){
        return N==0;
    }


    public int length(){

        return N;
    }

    public T get(int i){

        Node n=head.next;
        for (int j = 0; j <i ; j++) {
            n=n.next;
        }
        return n.item;
    }

    public void insert(T t){
        //找到最后一个节点
        Node n=head;
        while(n.next!=null){
            n=n.next;
        }
        Node newNode=new Node(t,null);
        n.next=newNode;
        N++;
    }

    public void insert(int i,T t){
        Node n=head;
        //找到i位置的前一个节点
        for (int j = 0; j <= i-1; j++) {
           n=n.next;
        }
        Node temp=n.next;
        //将新节点下一个节点指向前一节点的下一节点
        Node newNode=new Node(t,temp);
        //将前一个节点的下一个节点指向新节点
        n.next=newNode;
        N++;
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
        return new LIterator();
    }

    private class LIterator implements Iterator{

        private Node n;

        public LIterator() {
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



    public void reverse(){
        if(isEmpty()){
            return;
        }
        reverse(head.next);

    }

    private Node reverse(Node curr) {
        if(curr.next==null){
            head.next=curr;
            return curr;
        }
        //当前节点的下一个节点是反转后当前节点的上一个节点
        System.out.println("currbefore"+curr.item);
        Node pre=reverse(curr.next);
        System.out.println("pre"+pre.item);
        System.out.println("curr"+curr.item);
        //让返回的节点的下一个节点变为当前节点curr
        pre.next=curr;
        //当前节点的下一个节点为null
        curr.next=null;
        return curr;
    }


}
