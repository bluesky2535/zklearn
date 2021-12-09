package com.zklearn.tree;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.tree
 * @Author: zk
 * @CreateTime: 2021-12-09 16:33:29
 * @Description: 折纸问题
 */
public class PageFolder {

    public static void main(String[] args) {

    }
    public static void createTree(int N) {
        //定义根节点
        Node root=null;
        for (int i = 0; i < N; i++) {
            //第一次对折
            if(i==0){
                root=new Node("down",null,null);
            }else{

            }

        }
        
    }

    public static void printTree() {

    }


    private static class Node<T>{
        //节点数据
        public T item;
        //下一节点
        Node left;
        Node right;

        public Node(T item, Node left,Node right){
            this.item=item;
            this.left=left;
            this.right=right;
        }
    }
}
