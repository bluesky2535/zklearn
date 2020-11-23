package com.zklearn;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class TestAnnotation {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.zklearn.Student");
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation value : annotations) {
            System.out.println(value);
        }
        //获取当前类的注解
        ZkTable annotation = aClass.getAnnotation(ZkTable.class);
        System.out.println(annotation.value());


        //获取所有的字段
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("**********************");
            String filedName = declaredField.getName();

            //获取这个字段所有的注解
            Annotation[] filedAnnotations = declaredField.getAnnotations();
            for (Annotation filedAnnotation : filedAnnotations) {

//                System.out.println(filedAnnotation.annotationType().getTypeName());
//                System.out.println(ZkField.class.getTypeName());

                //判断是否是ZkField注解
                boolean annotationPresent = declaredField.isAnnotationPresent(ZkField.class);
                if (annotationPresent) {
                    ZkField zkField = (ZkField) declaredField.getAnnotation(filedAnnotation.annotationType());
                    System.out.println("字段名：" + filedName + " " + "表列名" + zkField.columnName() + " " + "表字段类型" + zkField.type() + " " + "表字段长度" + zkField.length());

                }

            }


        }

    }
}
