package com.zklearn.linear;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.linear
 * @Author: zk
 * @CreateTime: 2021-12-07 15:38:11
 * @Description: 约瑟夫问题
 */
public class YueSeFu<T> {

    public static void main(String[] args) {

        Node<Integer> first=null;
        Node<Integer> pre=null;

        for (int i = 1; i <= 41 ; i++) {
            if(i==1){
                first=new Node(i,null);
                pre=first;
                continue;
            }
            Node<Integer> newNode=new Node(i,null);
            pre.next=newNode;
            pre=newNode;
            if(i==41){
                pre.next=first;
            }

        }


        //进行循环
        int count =0;
        Node<Integer> n=first;
        Node<Integer> before=null;
        //最后一个节点自循环
        while (n!=n.next){
            count++;
            if (count == 3) {
                before.next=n.next;
                System.out.print(n.item+",");
                count=0;
                n=n.next;
            }else{
                before=n;
                n=n.next;
            }
        }
        System.out.print(n.item);

    }



    private static class Node<T>{
        //节点数据
        T item;
        //下一节点
        Node next;

        public Node(T item,Node next){
            this.item=item;
            this.next=next;
        }
    }

}
