package com.zk.designmodel.observermodel;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        LiSi liSi=new LiSi();
        ArrayList<Observer> observers = new ArrayList<>();
        HanFeiZi hanFeiZi=new HanFeiZi();
        hanFeiZi.addObserver(liSi);
        hanFeiZi.haveBreakfast();
    }
}
