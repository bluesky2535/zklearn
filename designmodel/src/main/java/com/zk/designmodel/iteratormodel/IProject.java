package com.zk.designmodel.iteratormodel;

public interface IProject {
    //获取项目信息
    public String getProjectInfo();
    //增加项目
    public void add(String name,int num,int cost);
    //获取一个可以遍历的对象
    public IProjectIterator iterator();
}
