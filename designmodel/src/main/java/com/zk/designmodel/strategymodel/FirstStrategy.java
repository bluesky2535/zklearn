package com.zk.designmodel.strategymodel;

public class FirstStrategy implements Strategy{
    @Override
    public void operate() {
        System.out.println("第一种策略");
    }
}
