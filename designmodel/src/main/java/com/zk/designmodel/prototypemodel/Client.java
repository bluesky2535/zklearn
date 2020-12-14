package com.zk.designmodel.prototypemodel;

public class Client {

    public static void main(String[] args) throws Exception {
        Prototype prototype=new Prototype();
        Prototype clone = prototype.clone();
        System.out.println(prototype==clone);
        clone.method1();
    }

}
