package com.zk.designmodel.abstractfactory;

public abstract class AbstractBlackHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("黑色人种的皮肤颜色是黑色的");
    }

    @Override
    public void talk() {
        System.out.println("黑色人种说话，一般都听不懂");
    }
}
