package com.zk.designmodel.facademodel;

public class Facade {

    ClassA classA=new ClassA();
    ClassB classB=new ClassB();
    ClassC classC=new ClassC();



    public void methodA(){
        System.out.println("A类的A方法");
    }
    public void methodB(){
        System.out.println("B类的B方法");
    }
    public void methodC(){
        System.out.println("C类的C方法");
    }
}
