package com.zk.designmodel.proxymodel;

public class GamePlayer  implements IGamePlayer{
    @Override
    public void login(String username, String password) {
        System.out.println("玩家登录游戏");
    }

    @Override
    public void killBoss() {
        System.out.println("玩家在打怪");
    }

    @Override
    public void upgrade() {
        System.out.println("玩家升级了");
    }
}
