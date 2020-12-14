package com.zk.designmodel.buildmodel;

public class BenzModel extends CarModel{
    @Override
    public void start() {
        System.out.println("奔驰启动");
    }

    @Override
    public void stop() {
        System.out.println("奔驰停止");

    }

    @Override
    public void alarm() {
        System.out.println("奔驰按喇叭");

    }

    @Override
    public void engineBoom() {
        System.out.println("奔驰引擎启动");

    }
}
