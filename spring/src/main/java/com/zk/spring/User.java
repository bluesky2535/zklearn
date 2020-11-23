package com.zk.spring;

public class User {

    public User(String name){
        System.out.println("构造函数1");
        this.name = name;
    }
    public User() {
        System.out.println("默认构造函数");
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private  String name;
}
