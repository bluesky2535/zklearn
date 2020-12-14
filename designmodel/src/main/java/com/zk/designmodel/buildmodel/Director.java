package com.zk.designmodel.buildmodel;

import java.util.ArrayList;

public class Director {

    BenzCarBuilder benzBuilder=new BenzCarBuilder();
    BMWCarBuilder  bmwBuilder=new BMWCarBuilder();
    ArrayList<String> sequence=new ArrayList<>();

    /**
     * 获取奔驰A种类型
     * @return
     */
    public BenzModel getABenzCarModel(){
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("stop");
        this.sequence.add("alarm");
        this.sequence.add("engineboom");
        benzBuilder.setSequence(sequence);

        return  (BenzModel)this.benzBuilder.getCarModel();
    }

    /**
     * 获取奔驰B种类型
     * @return
     */
    public BenzModel getBBenzCarModel(){
        this.sequence.clear();
        this.sequence.add("alarm");
        this.sequence.add("engineboom");
        this.sequence.add("start");
        this.sequence.add("stop");
        benzBuilder.setSequence(sequence);
        return  (BenzModel)this.benzBuilder.getCarModel();
    }


    /**
     * 获取宝马A种类型
     * @return
     */
    public BMWModel getABMWCarModel(){
        this.sequence.clear();
        this.sequence.add("start");
        this.sequence.add("stop");
        this.sequence.add("alarm");
        this.sequence.add("engineboom");
        bmwBuilder.setSequence(sequence);
        return  (BMWModel)this.bmwBuilder.getCarModel();
    }
}
