package com.zk.designmodel.iteratormodel;

import java.util.ArrayList;

public class Project implements IProject{

    ArrayList<IProject> projectList=new ArrayList<>();

    //项目名称
    private String name="";
    //项目成员数量
    private int num=0;
    //项目费用
    private int cost=0;

    public Project(String name, int num, int cost) {
        this.name = name;
        this.num = num;
        this.cost = cost;
    }

    public Project() {
    }

    @Override
    public String getProjectInfo() {
        String info="项目名称"+this.name+"项目人数"+this.num+"项目费用"+this.cost;
        return info;
    }

    @Override
    public void add(String name, int num, int cost) {
        projectList.add(new Project(name,num,cost));
    }

    @Override
    public IProjectIterator iterator() {
        return  new ProjectIterator(this.projectList);
    }


}
