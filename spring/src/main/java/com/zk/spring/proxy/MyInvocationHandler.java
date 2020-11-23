package com.zk.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

    private Sell sell;

    public void setSell(Sell sell) {
        this.sell = sell;
    }


    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),sell.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法前");
        Object res = method.invoke(sell, args);
        System.out.println("执行方法后");

        return res;
    }
}
