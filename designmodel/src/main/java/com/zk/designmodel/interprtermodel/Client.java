package com.zk.designmodel.interprtermodel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Client {

    public static void main(String[] args) throws Exception {
        String expStr=getExpStr();
        HashMap<String,Integer> var=getValue(expStr);
        Calculator cal=new Calculator(expStr);
        System.out.println("运算结果为"+expStr+"="+cal.run(var));
    }

    private static String getExpStr() throws IOException {
        System.out.println("请输入表达式");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    private static HashMap<String,Integer> getValue(String expStr) throws IOException {
        HashMap<String,Integer> map=new HashMap<>();
        for (char c : expStr.toCharArray()) {
            if(c!='+'&& c!='-'){
                if(!map.containsKey(String.valueOf(c))){
                    String in=(new BufferedReader(new InputStreamReader(System.in))).readLine();
                    map.put(String.valueOf(c),Integer.valueOf(in));
                }
            }
        }
        return map;
    }

}
