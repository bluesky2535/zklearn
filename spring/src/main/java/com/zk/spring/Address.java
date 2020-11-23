package com.zk.spring;

public class Address {
    public  Address(){

    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    private String aname;

    @Override
    public String toString() {
        return "Address{" +
                "aname='" + aname + '\'' +
                '}';
    }
}
