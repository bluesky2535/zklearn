package com.zk.designmodel.adaptermodel;

public class OutUserInfo extends OutUser implements IUserInfo {
    @Override
    public String getUserName() {
        String userName = (String)super.getUserBaseInfo().get("userName");
        return userName;
    }

    @Override
    public String getHomeAddress() {
        String address =(String) super.getUserHomeInfo().get("address");
        return address;
    }

    @Override
    public String getTelephone() {
        String tel =(String) super.getUserBaseInfo().get("tel");

        return tel;
    }

    @Override
    public String getJobPosition() {
        String job =(String) super.getUserOfficeInfo().get("job");
        return job;
    }
}
