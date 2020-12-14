package com.zk.designmodel;


/**
 * 单例模式
 */
public class Single {
    private static  Single single=new Single();
    private Single(){

    }
    public static Single getInstance(){
        return single;
    }
}
