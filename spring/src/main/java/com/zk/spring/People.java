package com.zk.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

import javax.annotation.Resource;

public class People {


    @Nullable
    private Dog dog;
    @Autowired
    @Qualifier(value = "cat1")
    private Cat cat;

    @Resource(name = "wandou")
    private Cat cat2;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }



    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Cat getCat2() {
        return cat2;
    }

    public void setCat2(Cat cat2) {
        this.cat2 = cat2;
    }

    @Override
    public String toString() {
        return "People{" +
                "dog=" + dog +
                ", cat=" + cat +
                ", cat2=" + cat2 +
                ", name='" + name + '\'' +
                '}';
    }
}
