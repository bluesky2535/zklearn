package com.zk.designmodel.iteratormodel;

import java.util.ArrayList;

public class BossClient {

    public static void main(String[] args) {

        IProject project=new Project();
//        ArrayList<IProject> projects=new ArrayList<>();
//        //增加项目
        project.add("生态厕所",10,10000);
        project.add("生态民居",2,6000);
        project.add("生态度假村",20,5222);


        IProjectIterator projectIterator=project.iterator();

        while (projectIterator.hasNext()){
            IProject next = (IProject)projectIterator.next();
            System.out.println(next.getProjectInfo());
        }


    }
}
