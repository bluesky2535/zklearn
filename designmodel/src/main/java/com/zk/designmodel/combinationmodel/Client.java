package com.zk.designmodel.combinationmodel;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        //创建一个根节点
        Composite root=new Composite();
        root.doSomething();
        //创建一个树枝节点
        Composite branch=new Composite();
        branch.doSomething();
        root.add(branch);
        //创建一个叶子节点
        Leaf leaf=new Leaf();
        branch.add(leaf);

        display(root);

    }

    //通过递归遍历树
    public static void display(Composite root){
        ArrayList<Component> children = root.getChildren();
        for (Component child : children) {
            if(child instanceof Leaf){
                child.doSomething();
            }else{
                display((Composite) child);
            }
        }

    };

}
