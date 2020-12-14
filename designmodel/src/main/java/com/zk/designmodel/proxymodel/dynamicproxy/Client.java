package com.zk.designmodel.proxymodel.dynamicproxy;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        IGamePlayer iGamePlayer=new GamePlayer();
        ClassLoader cl=iGamePlayer.getClass().getClassLoader();
        InvocationHandler ih=new IGamePlayerIH(iGamePlayer);
        IGamePlayer  proxyInstance =(IGamePlayer) Proxy.newProxyInstance(cl, new Class[]{IGamePlayer.class}, ih);
        proxyInstance.login("zhangsan","123456");
        proxyInstance.killBoss();
        proxyInstance.upgrade();
    }
}
