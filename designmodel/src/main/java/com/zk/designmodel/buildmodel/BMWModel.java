package com.zk.designmodel.buildmodel;

public class BMWModel extends CarModel{
    @Override
    public void start() {
        System.out.println("宝马启动");
    }

    @Override
    public void stop() {
        System.out.println("宝马停止");
    }

    @Override
    public void alarm() {
        System.out.println("宝马按喇叭");
    }

    @Override
    public void engineBoom() {
        System.out.println("宝马引擎启动");
    }
}
