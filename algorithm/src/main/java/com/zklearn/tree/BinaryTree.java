package com.zklearn.tree;

import com.zklearn.linear.Queue;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.tree
 * @Author: zk
 * @CreateTime: 2021-12-08 15:13:49
 * @Description: 二叉查找树
 */
public class BinaryTree<Key extends Comparable,Value> {
    public static void main(String[] args) {
/*        BinaryTree<Integer,Integer> binaryTree=new BinaryTree<>();
        binaryTree.put(1,11);
        binaryTree.put(2,22);
        binaryTree.put(3,33);
        binaryTree.put(4,44);
        System.out.println(binaryTree.size());
        binaryTree.delete(2);
        System.out.println(binaryTree.size());
        Integer integer = binaryTree.get(3);
        System.out.println("获取键值3的值为"+integer);*/

        //测试前序遍历
        BinaryTree<String,String> tree=new BinaryTree<>();
        tree.put("E","5");
        tree.put("B","2");
        tree.put("G","7");
        tree.put("A","1");
        tree.put("D","4");
        tree.put("F","6");
        tree.put("H","8");
        tree.put("C","3");

        System.out.println("===前序遍历=========");
        Queue<String> queue = tree.preErgodic();
        for (String s : queue) {
            System.out.print(s);

        }
        System.out.println();
        System.out.println("===中序遍历=========");

        Queue<String> queue1 = tree.midErgodic();
        for (String s : queue1) {
            System.out.print(s);

        }
        System.out.println();
        System.out.println("===后序遍历=========");

        Queue<String> queue2 = tree.afterErgodic();
        for (String s : queue2) {
            System.out.print(s);

        }
        System.out.println();
        System.out.println("=== 层序遍历=========");

        Queue<String> queue3 = tree.layerErgodic();
        for (String s : queue3) {
            System.out.print(s);

        }
        System.out.println();
        System.out.print("===最大深度=========");


        int depth = tree.maxDepth();
        System.out.println(depth);


    }

    private int N;

    private Node root;


    public BinaryTree() {
        this.N=0;
        this.root=null;
    }

    private class Node{
        //节点数据
        Key key;
        Value value;
        //下一节点
        Node left;
        Node right;

        public Node( Key key,Value value, Node left,Node right){
            this.key=key;
            this.value=value;
            this.left=left;
            this.right=right;
        }
    }


    public int size(){
        return N;
    }

    public void put(Key key, Value value){
        root=put(root,key,value);
    }

    public Node put(Node x,Key key, Value value){
        //如果子树为空
        if(x==null){
            N++;
            return new Node(key,value,null,null);
        }
        //比较X节点的键和key的大小
        int cmp = x.key.compareTo(key);

        if(cmp<0){
            //如果key大于x节点的键，则替换x节点的右子树
            x.right = put(x.right, key, value);
        }else if(cmp>0){
            //如果key小于x节点的键，则继续找x节点的左子树
            x.left = put(x.left, key, value);
        }else{
            //如果key等于x节点的键，则替换x节点对应的value值
            x.value=value;
        }
        return x;
    }

    public Value get(Key key){
        return get(root,key);
    }

    public Value get(Node x,Key key){
        //如果子树为空
        if(x==null){
            return null;
        }
        //比较X节点的键和key的大小
        int cmp = x.key.compareTo(key);

        if(cmp>0){
            //如果key大于x节点的键，则替换x节点的右子树
            return  get(x.right,key);
        }else if(cmp<0){
            //如果key小于x节点的键，则继续找x节点的左子树
            return  get(x.left,key);
        }else{
            //如果key等于x节点的键，则返回值
            return  x.value;
        }
    }
    public void delete(Key key){
         delete(root,key);
    }

    public Node delete(Node x,Key key){
        //如果子树为空
        if(x==null){
            return null;
        }
        //比较X节点的键和key的大小
        int cmp = x.key.compareTo(key);

        if(cmp>0){
            //如果key大于x节点的键，则继续找x节点的右子树
           x.right=delete(x.right,key);
        }else if(cmp<0){
            //如果key小于x节点的键，则继续找x节点的左子树
            x.left=delete(x.left,key);
        }else{
            //如果key等于x节点的键
            N--;
            //如果x的左子树为空，则直接将右子树上移
            if(x.left==null){
               return  x.right;

            }
            //如果x的右子树为空，则直接将左子树上移
            if(x.right==null){
                return  x.left;
            }
            //开始找右子树最左边的节点,即为最小的节点
            Node minNode=x.right;
            while (minNode.left!=null){
                minNode=minNode.left;
            }
            //将该最小节点从原右子树中删除掉
            Node n=x.right;
            while(n.left.left!=null){
                n=n.left;
            }
            n.left=null;
            //设置该最小节点的左子树和右子树
            minNode.left=x.left;
            minNode.right=x.right;
            x=minNode;

        }
        return x;
    }


    public Key min(){
        return  min(root).key;
    }

    /**
     * 树的最小键
     * @param x
     * @return
     */
    private Node min(Node x) {
        if (x.left!=null){
           return min(x.left);
        }else{
            return x;
        }
    }


    public Key max(){
        return  max(root).key;
    }

    /**
     * 树的最大键
     * @param x
     * @return
     */
    private Node max(Node x) {
        if (x.right!=null){
            return min(x.right);
        }else{
            return x;
        }
    }


    public Queue<Key> preErgodic(){
        Queue queue=new Queue();
        preErgodic(root,queue);
        return queue;
    }


    // 前序遍历
    private void preErgodic(Node x, Queue<Key> queue) {
        if(x==null){
            return;
        }
        //把X节点的key放入队列中
        queue.enterQueue(x.key);

        //遍历X节点的左子树
        if(x.left!=null){
            preErgodic(x.left,queue);
        }

        //遍历X节点的右子树
        if(x.right!=null){
            preErgodic(x.right,queue);
        }
    }
    public Queue<Key> midErgodic(){
        Queue queue=new Queue();
        midErgodic(root,queue);
        return queue;
    }
    // 中序遍历
    private void midErgodic(Node x, Queue<Key> queue) {
        if(x==null){
            return;
        }
        //遍历X节点的左子树
        if(x.left!=null){
            midErgodic(x.left,queue);
        }
        //把X节点的key放入队列中
        queue.enterQueue(x.key);

        //遍历X节点的右子树
        if(x.right!=null){
            midErgodic(x.right,queue);
        }
    }


    public Queue<Key> afterErgodic(){
        Queue queue=new Queue();
        afterErgodic(root,queue);
        return queue;
    }
    // 后序遍历
    private void afterErgodic(Node x, Queue<Key> queue) {
        if(x==null){
            return;
        }
        //遍历X节点的左子树
        if(x.left!=null){
            afterErgodic(x.left,queue);
        }
        //遍历X节点的右子树
        if(x.right!=null){
            afterErgodic(x.right,queue);
        }
        //把X节点的key放入队列中
        queue.enterQueue(x.key);
    }



    //层序遍历
    private Queue<Key> layerErgodic() {
        Queue<Key> keys=new Queue<>();
        Queue<Node> nodes=new Queue<>();

        nodes.enterQueue(root);

        while (!nodes.isEmpty()){
            Node n=nodes.deleteQueue();
            keys.enterQueue(n.key);
            if(n.left!=null){
                nodes.enterQueue(n.left);
            }
            if(n.right!=null){
                nodes.enterQueue(n.right);
            }
        }
        return keys;
    }


    public int maxDepth(){
        return maxDepth(root);
    }
    public int maxDepth(Node x){
        if(x==null){
            return 0;
        }
        int max=0;
        int maxL=0;
        int maxR=0;

        //左子树的最大深度
        if(x.left!=null){
            maxL=maxDepth(x.left);
        }
        //右子树的最大深度
        if(x.right!=null){
            maxR=maxDepth(x.right);
        }
        //左子和右子的最大深度取最大
        max=maxL>maxR?maxL+1:maxR+1;
        return max;
    }


}
