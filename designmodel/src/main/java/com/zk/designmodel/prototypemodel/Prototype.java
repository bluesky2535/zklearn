package com.zk.designmodel.prototypemodel;

import java.util.ArrayList;

public class Prototype implements Cloneable {

    private ArrayList<String> arrayList = new ArrayList<>();

    public void method1() {
        System.out.println("执行方法1");
    }

    @Override
    protected Prototype clone() throws CloneNotSupportedException {
        Prototype p = (Prototype) super.clone();
        //对对象中的引用数据进行深拷贝
        p.arrayList = (ArrayList<String>) this.arrayList.clone();

        return p;
    }
}
