package com.zk.designmodel.factorymethod;

public class ConcreteProduct2 implements Product{
    @Override
    public void method1() {
        System.out.println("第二种产品"+"method1");
    }

    @Override
    public void method2() {
        System.out.println("第二种产品"+"method2");
    }
}
