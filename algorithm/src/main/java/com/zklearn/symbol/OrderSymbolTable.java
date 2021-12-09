package com.zklearn.symbol;

import lombok.val;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.linear
 * @Author: zk
 * @CreateTime: 2021-12-08 10:57:44
 * @Description: 有序符号表
 */
public class OrderSymbolTable<Key extends Comparable<Key>,Value> {


    public static void main(String[] args) {
        OrderSymbolTable<String,Integer> symbolTable=new OrderSymbolTable<>();
        symbolTable.put("aa",123);
        symbolTable.put("bb",333);
        symbolTable.put("cc",52);
        symbolTable.put("gg",68);

        System.out.println("符号表的长度"+symbolTable.size());

        symbolTable.put("dd",524);

        System.out.println("符号表的长度"+symbolTable.size());

    }

    private class Node{
        //节点数据
        Key key;
        Value value;
        //下一节点
        Node next;

        public Node(Key key,Value value, Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }

    public OrderSymbolTable() {
        this.head=new Node(null,null,null);
        this.N=0;
    }

    private Node head;
    private int N;

    public Value get(Key key){
        Node n=head;
        while (n.next!=null){
            n=n.next;
            if (n.key.equals(key)) {
                return n.value;
            }
        }
        return null;
    }


    public void put(Key key,Value value){
        Node n=head;
        while (n.next!=null && key.compareTo(n.next.key)>0){
                n=n.next;
        }
        if(n.next!=null && key.compareTo(n.next.key)==0){
            n.next.value=value;
            return;
        }


        Node oldNext=n.next;
        Node newNode = new Node(key, value, oldNext);
        n.next=newNode;
        N++;
    }


    public void delete(Key key){
        Node n=head;
        while (n.next!=null){
            if (n.next.key.equals(key)) {
                n.next=n.next.next;
                N--;
                return;
            }
            n=n.next;
        }
    }

    public int size(){
        return N;
    }


}
