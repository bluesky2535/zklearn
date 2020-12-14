package com.zk.designmodel.templatemodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {


    public static void main(String[] args) throws IOException {
        Hummer1 hummer1 = new Hummer1();
        String isAlarm = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if (isAlarm == "false") {
            hummer1.setAlarm(false);
        } else {
            hummer1.setAlarm(true);
        }
        hummer1.run();
    }
}
