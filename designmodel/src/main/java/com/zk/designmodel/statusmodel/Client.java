package com.zk.designmodel.statusmodel;

public class Client {

    public static void main(String[] args) {
        Context context=new Context();
        context.setLiftState(new CloseingState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
