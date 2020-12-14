package com.zk.designmodel.proxymodel.forceProxy;


public class Client {

    public static void main(String[] args) {

        /**
         * 创建真实角色
         */
        IGamePlayer iGamePlayer = new GamePlayer();


        /**
         *直接调用
         */
        iGamePlayer.login("张三", "123456");
        iGamePlayer.killBoss();
        iGamePlayer.upgrade();

        /**
         * 自行创建代理
         */
        GamePlayerProxy gamePlayerProxy = new GamePlayerProxy(iGamePlayer);
        gamePlayerProxy.login("张三", "123456");
        gamePlayerProxy.killBoss();
        gamePlayerProxy.upgrade();


        /**
         * 自行创建代理
         */
        IGamePlayer proxy = iGamePlayer.getProxy();
        proxy.login("张三", "123456");
        proxy.killBoss();
        proxy.upgrade();

    }
}
