package com.zklearn.linear;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.linear
 * @Author: zk
 * @CreateTime: 2021-12-07 15:08:03
 * @Description: 快慢指针 找到环的入口
 */

public class SlowQuickCircleEntrance {

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

        seven.next=fourth;
        System.out.println("环的入口"+getCircleEntrance(first).item);

    }

    private static Node getCircleEntrance(Node<String> node) {

        Node quick=node;
        Node slow=node;
        Node temp=null;

        while(quick.next!=null){
            quick=quick.next.next;
            slow=slow.next;

            if(quick.equals(slow)){
                temp=node;
                continue;
            }
            if(temp!=null){
                temp=temp.next;
                if(temp.equals(slow)){
                    break;
                }
            }

        }
        return temp;
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
