package com.zk.designmodel.abstractfactory;

public  class FemaleYellowHuman extends AbstractYellowHuman{

    @Override
    public void getSex() {
        System.out.println("黄色女性");
    }
}
