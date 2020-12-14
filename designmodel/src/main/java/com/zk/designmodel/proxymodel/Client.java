package com.zk.designmodel.proxymodel;

public class Client {

    public static void main(String[] args) {
        IGamePlayer iGamePlayer=new GamePlayer();
        GamePlayerProxy gamePlayerProxy=new GamePlayerProxy(iGamePlayer);
        gamePlayerProxy.login("张三","123456");
        gamePlayerProxy.killBoss();
        gamePlayerProxy.upgrade();
    }
}
