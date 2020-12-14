package com.zk.designmodel.proxymodel.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class IGamePlayerIH implements InvocationHandler {
    //被代理者
    Class aClass=null;
    //被代理的实例
    Object obj=null;
    //我要代理谁
    public IGamePlayerIH(Object _obj){
        this.obj=_obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object invoke = method.invoke(this.obj,args);
        return invoke;
    }
}
