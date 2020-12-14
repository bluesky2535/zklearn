package com.zk.designmodel.abstractfactory;

public abstract class AbstractYellowHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("黄色人种的皮肤颜色是黄色的");
    }

    @Override
    public void talk() {
        System.out.println("黄色人种说话，一般都是双字节");
    }
}
