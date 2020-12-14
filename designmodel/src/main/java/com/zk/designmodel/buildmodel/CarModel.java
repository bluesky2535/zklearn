package com.zk.designmodel.buildmodel;

import javax.sound.midi.Sequence;
import java.util.ArrayList;

public abstract class CarModel {

    ArrayList<String> sequence =new ArrayList<>();

    public abstract void start();

    public abstract void stop();

    public abstract void alarm();

    public abstract void engineBoom();


    public void run() {
        for (int i = 0; i < sequence.size(); i++) {
           String actionName=sequence.get(i);
           switch (actionName){
               case "start":
                   this.start();
                   break;
               case "stop":
                   this.stop();
                   break;
               case  "alarm":
                   this.alarm();
                   break;
               case "engineboom":
                   this.engineBoom();
                   break;
           }
        }
    }

    /**
     * 设置序列
     * @param sequence
     */
    public void setSequence(ArrayList<String> sequence) {
        this.sequence = sequence;
    }
}
