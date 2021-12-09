package com.zklearn.linear;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.linear
 * @Author: zk
 * @CreateTime: 2021-12-07 15:08:03
 * @Description: 快慢指针判断是否有环问题
 */

public class SlowQuickCircle {

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

//        seven.next=fourth;



        System.out.println("是否有环"+judgeCircle(first));

    }

    private static boolean judgeCircle(Node<String> node) {

        Node quick=node;
        Node slow=node;

        while(quick.next!=null){
            quick=quick.next.next;
            slow=slow.next;

            if(quick.equals(slow)){
                return true;
            }
        }


        return false;

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
