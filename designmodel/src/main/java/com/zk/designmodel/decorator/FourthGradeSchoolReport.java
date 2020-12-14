package com.zk.designmodel.decorator;

public class FourthGradeSchoolReport extends SchoolReport {
    @Override
    public void report() {
        System.out.println("数学10 语文20 英语30");
    }

    @Override
    public void sign(String name) {
        System.out.println("家长签名"+name);
    }
}
