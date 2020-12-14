package com.zk.designmodel.adaptermodel;

import java.util.Map;

public interface IOutUser {
    //基本信息
    public Map getUserBaseInfo();
    //工作区域信息
    public Map getUserOfficeInfo();
    //用户的家庭信息
    public Map getUserHomeInfo();

}
