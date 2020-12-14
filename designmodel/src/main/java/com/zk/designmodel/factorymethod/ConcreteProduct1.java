package com.zk.designmodel.factorymethod;

public class ConcreteProduct1  implements Product{
    @Override
    public void method1() {
        System.out.println("第一种产品"+"method1");
    }

    @Override
    public void method2() {
        System.out.println("第一种产品"+"method2");

    }
}
