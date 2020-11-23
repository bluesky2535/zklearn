package com.zklearn;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Demo02 {
    @Demo01Annotation(age = 19, studentName = "王五", schools = {"北京大学"})
    public void test1() {

    }

    @Demo02Annotation("hahh")
    public void test2() {

    }


    public static void main(String[] args) throws ClassNotFoundException {


    }
}
