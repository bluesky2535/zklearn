package com.zk.designmodel.observermodel;

public class LiSi  implements Observer{
    @Override
    public void update(String context) {
        System.out.println("监察到韩非子在做以下活动："+context);
    }
}
