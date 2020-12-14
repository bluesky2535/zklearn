package com.zk.designmodel.responsemodel;

import java.util.ArrayList;
import java.util.Random;

public class Client {


    public static void main(String[] args) {
        //随机挑选几个女性
        Random rand =new Random();
        ArrayList<IWomen> arrayList=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList.add(new Women(rand.nextInt(4),"出去逛街"));
        }
        //定义三个请示对象
        Handler father=new Father() ;
        Handler husband=new Husband() ;
        Handler son=new Son() ;

        //设置请求顺序
        father.setNext(husband);
        husband.setNext(son);

        for (IWomen iWomen : arrayList) {
            father.HandleMessage(iWomen);
        }

    }
}
