package com.zklearn.linear;

import javax.xml.soap.Node;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.linear
 * @Author: zk
 * @CreateTime: 2021-12-07 15:08:03
 * @Description: 快慢指针中间值问题
 */

public class SlowQuickMid {

    public static void main(String[] args) {
        Node<String> first =new Node<>("aa",null);
        Node<String> second =new Node<>("bb",null);
        Node<String> third =new Node<>("cc",null);
        Node<String> fourth =new Node<>("dd",null);
        Node<String> fifth =new Node<>("ee",null);
        Node<String> sixth =new Node<>("ff",null);
        Node<String> seven =new Node<>("gg",null);


        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=sixth;
        sixth.next=seven;

        Node mid = getMid(first);
        System.out.println("中间值为"+mid.item);

    }



    public static Node getMid(Node<String> node){

        Node quick=node;
        Node slow=node;

        while(quick.next!=null){
            quick=quick.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public static class Node<T>{

        private T item;
        private Node next;

        public Node(T item,Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
