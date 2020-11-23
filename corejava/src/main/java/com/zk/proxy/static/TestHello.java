package com.zk.proxy;

public class TestHello {

    //静态代理
    public static void main(String[] args) {
        HelloProxy helloProxy=new HelloProxy();
        helloProxy.sayHello();
    }
}
