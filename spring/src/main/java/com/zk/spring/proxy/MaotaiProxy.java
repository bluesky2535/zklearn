package com.zk.spring.proxy;

public class MaotaiProxy implements Sell{
    private Maotai maotai;

    public MaotaiProxy(Maotai maotai){
        this.maotai=maotai;
    }

    public void sell(){
        System.out.println("开店");
        maotai.sell();
        System.out.println("上报");
    }

}
