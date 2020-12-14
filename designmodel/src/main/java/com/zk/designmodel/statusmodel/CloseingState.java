package com.zk.designmodel.statusmodel;

public class CloseingState  extends LiftState{
    @Override
    public void open() {
        super.context.setLiftState(Context.openingState);//置为开门状态
        super.context.getLiftState().open();
    }

    @Override
    public void close() {
        System.out.println("电梯门关闭");
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.runningState);
        super.context.getLiftState().run();
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        super.context.getLiftState().stop();
    }
}
