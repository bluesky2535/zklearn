package com.zk.designmodel.yilaidaozhi;

public class Driver  implements IDriver{
    @Override
    public void drive(ICar iCar) {
        iCar.run();
    }
}
