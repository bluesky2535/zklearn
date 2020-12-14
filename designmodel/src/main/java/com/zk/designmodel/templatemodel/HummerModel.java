package com.zk.designmodel.templatemodel;

public abstract class HummerModel {

    public abstract void start();

    public abstract void stop();

    public abstract void alarm();

    public abstract void engineBoom();

    public abstract boolean getAlarm();
    public abstract boolean setAlarm(boolean isAlarm);


    public void run() {
        this.start();
        if(this.getAlarm()){
            this.alarm();
        }
        this.engineBoom();
        this.stop();
    }
}

