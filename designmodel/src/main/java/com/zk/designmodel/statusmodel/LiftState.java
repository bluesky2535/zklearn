package com.zk.designmodel.statusmodel;

public abstract class LiftState {

    protected Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
    //电梯门开启
    public abstract void open();
    //电梯门关闭
    public abstract void close();
    //运行
    public abstract void run();
    //停止
    public abstract void stop();

}
