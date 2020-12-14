package com.zk.designmodel.mementomodel;

public class Client {

    public static void main(String[] args) {
        Boy boy=new Boy();
        boy.setState("心情非常棒");
        System.out.println("小男孩最初状态"+boy.getState());
        Caretaker caretaker=new Caretaker();
        caretaker.setMemento(boy.createMemento());
        boy.changeState();
        System.out.println("小男孩追女孩的状态"+boy.getState());

        boy.restoreMemento(caretaker.getMemento());
        System.out.println("小男孩恢复后的状态"+boy.getState());

    }
}
