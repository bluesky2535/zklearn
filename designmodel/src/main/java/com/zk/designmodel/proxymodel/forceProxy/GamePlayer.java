package com.zk.designmodel.proxymodel.forceProxy;

public class GamePlayer  implements IGamePlayer {

    public GamePlayerProxy gamePlayerProxy=null;
    @Override
    public void login(String username, String password) {

        if(isProxy()){
            System.out.println("玩家登录游戏");
        }else {
            System.out.println("请使用代理");
        }
    }

    @Override
    public void killBoss() {
        if(isProxy()){
            System.out.println("玩家在打怪");
        }else {
            System.out.println("请使用代理");
        }
    }

    @Override
    public void upgrade() {
        if(isProxy()){
            System.out.println("玩家升级了");
        }else {
            System.out.println("请使用代理");
        }
    }


    public IGamePlayer getProxy(){
        gamePlayerProxy=new GamePlayerProxy(this);
        return gamePlayerProxy ;
    }
    /**
     * 判断是否是代理
     * @return
     */
    public boolean isProxy(){
       if(this.gamePlayerProxy==null) {
           return false;
       }else{
           return true;
       }
    }
}
