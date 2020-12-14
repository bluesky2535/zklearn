package com.zk.designmodel.abstractfactory;

public  class MaleWhiteHuman extends AbstractYellowHuman{

    @Override
    public void getSex() {
        System.out.println("白色男性");
    }
}
