package com.zklearn.tree;


/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.tree
 * @Author: zk
 * @CreateTime: 2021-12-13 10:50:04
 * @Description: 红黑树
 */
public class RedBlackTree<Key extends Comparable,Value> {


    public static void main(String[] args) {
        RedBlackTree<String,String> tree=new RedBlackTree<>();
        tree.put("1","张三");
        tree.put("2","李四");
        tree.put("3","王五");

        //从树中获取元素
        String r1 = tree.get("1");
        System.out.println(r1);
        String r2 = tree.get("2");
        System.out.println(r2);
        String r3 = tree.get("3");
        System.out.println(r3);


    }

    //根节点
    private Node root;
    //节点个数
    private int N;
    //红色链接标识
    private static final boolean RED=true;
    //黑色链接标识
    private static final boolean BLACK=false;


    //节点的结构
    private class Node{
        Key key;
        Value value;
        Node left;
        Node right;
        //父节点指向本节点链接的颜色
        boolean color;

        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }


    /**
     * 获取树中元素的个数
     * @return
     */
    public int size(){
        return N;
    }
    /**
     * 判断当前节点的父链接是否为红色
     * @return
     */
    private boolean isRed(Node x){
        if(x==null){
            return false;
        }
        return x.color==RED;
    }




    /**
     * 左旋调整
     * @param h
     * @return
     */
    private Node rotateLeft(Node h){
        //获取h节点的右节点为X
        Node x = h.right;
        //设置h的右节点为x的左节点
        h.right=x.left;
        //设置X的左节点为H
        x.left=h;
        //将x的color属性设置为h的color属性
        x.color=h.color;
        //设置h的color属性为红色
        h.color=RED;
        return x;
    }
    /**
     * 右旋调整
     * @param h
     * @return
     */
    private Node rotateRight(Node h){
        //获取h的左子节点标识为X
        Node x=h.left;
        //设置h的左子节点为x的右子节点
        h.left=x.right;
        //设置x的右子节点为h
        x.right=h;
        //设置x节点的color属性设置为h的color属性
        x.color=h.color;
        //设置h的color属性设置为红色
        h.color=RED;
        return x;
    }

    /**
     * 颜色反转，相当于完成拆分4-节点
     * @param h
     */
    private void flipColors(Node h){
        //当前节点变为红色
        h.color=RED;
        //左子节点和右子节点变为黑色
        h.left.color=BLACK;
        h.right.color=BLACK;
    }

    /**
     * 在整个树上存入相应的key,value
     * @param key
     * @param value
     */
    public void put(Key key, Value value){
        root=put(root,key,value);
        //根节点的颜色总是黑色
        root.color=BLACK;
    }

    /**
     * 在指定的树上，完成插入操作，并返回添加元素后新的树
     * @param h
     * @param key
     * @param value
     * @return
     */
    private Node put(Node h,Key key,Value value){
        if(h==null){
            N++;
            return new Node(key,value,null,null,RED);
        }
        int cmp=h.key.compareTo(key);
        if(cmp>0){
               h.left=put(h.left,key,value);
        }else if(cmp<0){
               h.right=put(h.right,key,value);
        }else{
            h.value=value;
        }

        //进行左旋：当当前节点的左子节点为黑色，右子节点为红色
        if(isRed(h.right) && !isRed(h.left)){
           h= rotateLeft(h);
        }
        //进行右旋:当当前节点的左子节点和左子节点的左子节点都为红色，需要右旋
        if(isRed(h.left) && isRed(h.left.left)){
            h=   rotateRight(h);
        }
        //颜色反转:当当前节点的左子节点和右子节点都为红色时
        if(isRed(h.left) && isRed(h.right)){
            flipColors(h);
        }
        return h;
    }

    /**
     * 根据key从树中找出对应的值
     * @param key
     * @return
     */
    public Value get(Key key){
        return get(root,key);
    }

    /**
     * 根据key从指定的树中查值
     * @param x
     * @param key
     * @return
     */
    private Value get(Node x,Key key){
        if(x==null){
            return null;
        }
        int cmp = x.key.compareTo(key);
        if(cmp>0){
            return get(x.left,key);
        }else if(cmp<0){
            return get(x.right,key);
        }else {
            return x.value;
        }
    }

































































}
