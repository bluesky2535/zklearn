package com.zk.designmodel.iteratormodel;

import java.util.ArrayList;

public class ProjectIterator implements IProjectIterator {

    private int currentItem=0;
    ArrayList<IProject> projectList=new ArrayList<>();
    public ProjectIterator(ArrayList<IProject> projectList) {
        this.projectList=projectList;
    }

    @Override
    public boolean hasNext() {
        //定义一个返回值
        boolean b=true;
        if(this.currentItem>=projectList.size()||this.projectList.get(this.currentItem)==null){
            b=false;
        }
        return b;
    }

    @Override
    public IProject next() {
        return this.projectList.get(this.currentItem++);
    }
}
