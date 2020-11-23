package com.zk.exception;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        Throwable t=new Throwable();
        StringWriter out=new StringWriter();
        t.printStackTrace(new PrintWriter(out));
        String description=out.toString();
        System.out.println(description);
        ArrayList<String> a=new ArrayList<>();
        a.add("ss");

        Thread ts= new Thread(() -> {
            while (true){
                System.out.println("sss");

            }
        });
        ts.start();
        assert 6>=5;
    }

}
