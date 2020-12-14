package com.zk.designmodel.yilaidaozhi;

public class Client {

    public static void main(String[] args) {
        IDriver driver=new Driver();
        ICar iCar=new Benw();
        driver.drive(iCar);
    }
}
