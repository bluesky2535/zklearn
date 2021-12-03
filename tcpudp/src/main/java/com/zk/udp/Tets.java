package com.zk.udp;

public class Tets {

    public static void main(String[] args) throws Exception {
        int a=10;
        int b=10;
        method(a,b);
        System.out.println("a="+a);
        System.out.println("b="+b);
    }

    private static void method(int a, int b) throws Exception {
        System.out.println("a=100,b=200");
        throw new Exception("傻叉");
    }
}
