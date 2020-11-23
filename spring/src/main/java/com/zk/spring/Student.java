package com.zk.spring;

import java.util.*;

public class Student {

    /*bean | ref | idref | list | set | map | props | value | null*/
    private  String name;
    private  Address address;
    private Properties properties;
    private List toys;
    private Map course;
    private Set hobby;
    private String wife;
    private String[] books;


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", hobby=" + hobby +
                ", course=" + course +
                ", toys=" + toys +
                ", wife='" + wife + '\'' +
                ", properties=" + properties +
                ", books=" + Arrays.toString(books) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set getHobby() {
        return hobby;
    }

    public void setHobby(Set hobby) {
        this.hobby = hobby;
    }

    public Map getCourse() {
        return course;
    }

    public void setCourse(Map  course) {
        this.course = course;
    }

    public List getToys() {
        return toys;
    }

    public void setToys(List toys) {
        this.toys = toys;
    }

    public String getWife() {
        return wife;
    }

    public void setWife(String wife) {
        this.wife = wife;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String[] getBooks() {
        return books;
    }

    public void setBooks(String[] books) {
        this.books = books;
    }


}
