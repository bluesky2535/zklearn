package com.zk.designmodel.strategymodel;

public class SecondStrategy implements Strategy{
    @Override
    public void operate() {
        System.out.println("第二种策略");
    }
}
