package com.zklearn.tree;

import com.zklearn.linear.Queue;

/**
 * @BelongsProject: zklearn
 * @BelongsPackage: com.zklearn.tree
 * @Author: zk
 * @CreateTime: 2021-12-09 16:33:29
 * @Description: 折纸问题
 */
public class PageFolder {

    public static void main(String[] args) {
        Node tree = createTree(2);
        printTree(tree);
    }
    public static Node createTree(int N) {
        //定义根节点
        Node<String> root=null;
        for (int i = 0; i < N; i++) {
            //第一次对折
            if(i==0){
                root=new Node("down",null,null);
                continue;
            }
            Queue<Node> queue = new Queue<>();
            queue.enterQueue(root);

            while (!queue.isEmpty()){
                //从队列中弹出一个节点
                Node<String> tmp = queue.deleteQueue();
                //如果有左子节点，则把左子节点放入到队列中
                if(tmp.left!=null){
                    queue.enterQueue(tmp.left);
                }
                //如果有右子节点，则把右子节点放入到队列中
                if(tmp.right!=null){
                    queue.enterQueue(tmp.right);
                }
                //如果同时没有左右子节点，则证明该节点为叶子节点，只需要给该节点创建左子节点和右子节点即可
                if(tmp.left==null && tmp.right==null){
                    tmp.left=new Node("down",null,null);
                    tmp.right=new Node("up",null,null);
                }
            }
        }
        return root;
    }

    public static void printTree(Node node ) {
        if(node==null){
            return;
        }
        if(node.left!=null){
            printTree(node.left);
        }

        System.out.print(node.item+" ");

        if(node.right!=null){
            printTree(node.right);
        }

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
