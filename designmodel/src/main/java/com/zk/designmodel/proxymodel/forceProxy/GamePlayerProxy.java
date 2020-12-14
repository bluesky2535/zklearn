package com.zk.designmodel.proxymodel.forceProxy;

public class GamePlayerProxy implements IGamePlayer {

    IGamePlayer iGamePlayer = null;

    public GamePlayerProxy(IGamePlayer gamePlayer) {
        this.iGamePlayer = gamePlayer;
    }

    @Override
    public void login(String username, String password) {
        this.iGamePlayer.login(username, password);
    }

    @Override
    public void killBoss() {
        this.iGamePlayer.killBoss();
    }

    @Override
    public void upgrade() {
        this.iGamePlayer.upgrade();
    }

    @Override
    public IGamePlayer getProxy() {
        return this;
    }
}
