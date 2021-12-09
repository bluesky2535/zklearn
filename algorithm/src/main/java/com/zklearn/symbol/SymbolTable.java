package com.zklearn.symbol;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.linear
 * @Author: zk
 * @CreateTime: 2021-12-08 10:57:44
 * @Description: 符号表
 */
public class SymbolTable<Key,Value> {


    public static void main(String[] args) {
        SymbolTable<String,Integer> symbolTable=new SymbolTable<>();
        symbolTable.put("aa",123);
        symbolTable.put("bb",333);
        symbolTable.put("cc",52);
        symbolTable.put("gg",68);

        System.out.println("符号表的长度"+symbolTable.size());

        Integer aa = symbolTable.get("aa");
        System.out.println("对应的键值为"+aa);

        symbolTable.delete("aa");
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

    public SymbolTable() {
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
        while (n.next!=null){
            n=n.next;
            if (n.key.equals(key)) {
                n.value=value;
                return;
            }
        }
        Node oldFirst=head.next;
        Node newNode = new Node(key, value, oldFirst);
        head.next=newNode;
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
