package com.zk.designmodel.strategymodel;

public enum  EnumCalculator {


    ADD("+"){
        public int exec(int a,int b){
            return a+b;
        }
    },
    SUB("-"){
        public int exec(int a,int b){
            return a-b;
        }
    };


    EnumCalculator(String value) {
        this.value=value;
    }

    String value;

    public String getValue() {
        return this.value;
    }

    //声明一个抽象函数
    public abstract int exec(int a,int b);





}
