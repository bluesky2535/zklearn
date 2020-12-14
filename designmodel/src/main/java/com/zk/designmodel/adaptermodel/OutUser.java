package com.zk.designmodel.adaptermodel;

import java.util.HashMap;
import java.util.Map;

public class OutUser implements IOutUser {

    @Override
    public Map getUserBaseInfo() {
        HashMap baseInfoMap=new HashMap();
        baseInfoMap.put("userName","员工姓名");
        baseInfoMap.put("tel","员工电话");
        return baseInfoMap;
    }

    @Override
    public Map getUserOfficeInfo() {
        HashMap officeInfo=new HashMap();
        officeInfo.put("userName","员工姓名");
        officeInfo.put("job","员工职位是开发工程师");
        return officeInfo;
    }

    @Override
    public Map getUserHomeInfo() {
        HashMap homeInfo=new HashMap();
        homeInfo.put("userName","员工姓名");
        homeInfo.put("address","员工地址");
        return homeInfo;
    }
}
