package com.zk.designmodel.decorator;

public abstract  class Decorator extends SchoolReport{
    SchoolReport sr;

    Decorator(SchoolReport schoolReport){
        this.sr=schoolReport;
    }

}
