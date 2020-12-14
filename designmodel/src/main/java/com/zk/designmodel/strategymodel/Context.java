package com.zk.designmodel.strategymodel;

public class Context {
    Strategy strategy;
    Context(Strategy strategy){
        this.strategy=strategy;
    }


    public void operate(){
        this.strategy.operate();
    }
}
