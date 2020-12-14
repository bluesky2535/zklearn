package com.zk.designmodel.observermodel;

import java.util.ArrayList;

public class HanFeiZi implements IHanFeiZi, Observable {
    ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void haveBreakfast() {
        System.out.println("吃早餐");
        this.notifyObservers("吃早餐了");
    }

    @Override
    public void haveFun() {
        System.out.println("在玩耍");

        this.notifyObservers("玩嗨嗨");

    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers(String context) {
        for (Observer observer : observers) {
            observer.update(context);
        }
    }
}
