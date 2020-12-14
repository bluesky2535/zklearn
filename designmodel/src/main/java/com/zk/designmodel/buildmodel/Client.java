package com.zk.designmodel.buildmodel;

import java.util.ArrayList;

public class Client {

    public static void main(String[] args) {
        ArrayList<String> sequence=new ArrayList<>();
        sequence.add("engineboom");
        sequence.add("start");
        sequence.add("stop");

        BenzCarBuilder benzCarBuilder=new BenzCarBuilder();
        benzCarBuilder.setSequence(sequence);
        CarModel benzCarModel = benzCarBuilder.getCarModel();
        benzCarModel.run();


        BMWCarBuilder bmwCarBuilder=new BMWCarBuilder();
        bmwCarBuilder.setSequence(sequence);
        CarModel bmwCarModel = bmwCarBuilder.getCarModel();
        bmwCarModel.run();
    }
}
