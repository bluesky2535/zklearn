package com.zk.designmodel.observermodel;

public interface Observer {
    //一发现有动静，就采取行动
    public void update(String context);

}
