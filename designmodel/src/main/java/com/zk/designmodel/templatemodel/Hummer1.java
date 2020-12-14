package com.zk.designmodel.templatemodel;

public class Hummer1  extends HummerModel{

    boolean isAlarm=false;
    @Override
    public void start() {
        System.out.println("悍马1启动");
    }

    @Override
    public void stop() {
        System.out.println("悍马1停止");

    }

    @Override
    public void alarm() {
        System.out.println("悍马1按喇叭");

    }

    @Override
    public void engineBoom() {
        System.out.println("悍马1引擎发动");
    }

    @Override
    public boolean getAlarm() {
        return this.isAlarm;
    }

    @Override
    public boolean setAlarm(boolean isAlarm) {
        return this.isAlarm=isAlarm;
    }
}
