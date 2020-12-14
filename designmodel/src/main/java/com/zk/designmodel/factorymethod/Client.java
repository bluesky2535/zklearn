package com.zk.designmodel.factorymethod;

public class Client {
    public static void main(String[] args) {
        ConcreteCreator creator=new ConcreteCreator();
        Product product = creator.create(ConcreteProduct1.class);
        product.method1();
        product.method2();
        Product product2 = creator.create(ConcreteProduct2.class);
        product2.method1();
        product2.method2();
    }
}
