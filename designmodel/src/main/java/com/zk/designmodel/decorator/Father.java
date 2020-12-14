package com.zk.designmodel.decorator;

public class Father {

    public static void main(String[] args) {

        FourthGradeSchoolReport fourthGradeSchoolReport=new FourthGradeSchoolReport();

        Decorator decorator=new HighScoreSchoolReport(fourthGradeSchoolReport);

        decorator.report();
        decorator.sign("张三");
    }




}
