package com.zk.designmodel.buildmodel;

import java.util.ArrayList;

public class BenzCarBuilder extends CarBuilder {
    BenzModel benzModel=new BenzModel();
    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.benzModel.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.benzModel;
    }
}
