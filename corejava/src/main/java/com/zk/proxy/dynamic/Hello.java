package com.zk.proxy.dynamic;

/**
 * 被代理类
 */
public class Hello implements HelloInterface {
    @Override
    public void sayHello() {
        System.out.println("Hello zhanghao!");
    }
}