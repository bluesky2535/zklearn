package com.zk.designmodel.abstractfactory;

public  class MaleYellowHuman extends AbstractYellowHuman{

    @Override
    public void getSex() {
        System.out.println("黄色男性");
    }
}
