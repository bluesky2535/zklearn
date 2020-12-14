package com.zk.designmodel.decorator;

public class HighScoreSchoolReport extends Decorator{

    HighScoreSchoolReport(SchoolReport schoolReport) {
        super(schoolReport);
    }

    @Override
    public void report() {
        System.out.println("高分修饰");
        super.sr.report();

    }

    @Override
    public void sign(String name) {
        super.sr.sign(name);
    }
}
