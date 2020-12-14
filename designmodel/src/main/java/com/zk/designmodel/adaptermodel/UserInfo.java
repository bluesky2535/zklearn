package com.zk.designmodel.adaptermodel;

public class UserInfo implements IUserInfo{
    @Override
    public String getUserName() {
        System.out.println("这是员工的姓名");
        return null;
    }

    @Override
    public String getHomeAddress() {
        System.out.println("这是员工的地址");
        return null;
    }

    @Override
    public String getTelephone() {
        System.out.println("这是员工的电话");
        return null;
    }

    @Override
    public String getJobPosition() {
        System.out.println("这是员工的职位");
        return null;
    }
}
