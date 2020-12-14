package com.zk.designmodel.buildmodel;

import java.util.ArrayList;

public class BMWCarBuilder extends CarBuilder {
    BMWModel bmwModel=new BMWModel();
    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.bmwModel.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.bmwModel;
    }
}
