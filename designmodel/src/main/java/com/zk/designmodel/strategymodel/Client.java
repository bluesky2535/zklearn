package com.zk.designmodel.strategymodel;

public class Client {



    public static void main(String[] args) {
        FirstStrategy firstStrategy=new FirstStrategy();
        Context context=new Context(firstStrategy);
        context.operate();
    }

}
