package com.zk.designmodel.abstractfactory;

public class Client {

    public static void main(String[] args) {
        HumanFactory femaleHumanFactory=new FemaleHumanFactory();
        HumanFactory maleHumanFactory=new MaleHumanFactory();

        Human femaleBlackHuman = femaleHumanFactory.createBlackHuman();
        Human maleBlackHuman = maleHumanFactory.createBlackHuman();

        femaleBlackHuman.getColor();
        femaleBlackHuman.getSex();
        femaleBlackHuman.talk();


        maleBlackHuman.getColor();
        maleBlackHuman.getSex();
        maleBlackHuman.talk();
    }
}
