package com.zk.designmodel.proxymodel.forceProxy;

public interface IGamePlayer {

    public void login(String username,String password);
    public void killBoss();
    public void upgrade();

    IGamePlayer getProxy();
}
