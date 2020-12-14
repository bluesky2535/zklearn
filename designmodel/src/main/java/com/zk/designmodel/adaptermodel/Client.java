package com.zk.designmodel.adaptermodel;

public class Client {

    public static void main(String[] args) {
        IUserInfo userInfo=new OutUserInfo();
        System.out.println(userInfo.getHomeAddress());
        System.out.println(userInfo.getJobPosition());
        System.out.println(userInfo.getTelephone());
        System.out.println(userInfo.getUserName());
    }
}
