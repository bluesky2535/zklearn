package com.zk.designmodel.abstractfactory;

public abstract class AbstractWhiteHuman implements Human{
    @Override
    public void getColor() {
        System.out.println("白色人种的皮肤颜色是白色的");
    }

    @Override
    public void talk() {
        System.out.println("白色人种说话，一般都是单字节");
    }
}
