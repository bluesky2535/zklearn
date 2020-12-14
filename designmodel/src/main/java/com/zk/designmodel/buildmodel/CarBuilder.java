package com.zk.designmodel.buildmodel;

import java.util.ArrayList;

public abstract class CarBuilder {
    //设置序列
    public abstract void setSequence(ArrayList<String> sequence);
    //获取模型
    public abstract CarModel getCarModel();

}
