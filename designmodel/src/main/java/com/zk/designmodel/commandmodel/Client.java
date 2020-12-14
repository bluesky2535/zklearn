package com.zk.designmodel.commandmodel;

public class Client {
    public static void main(String[] args) {
        //定义接头人
        Invoker xiao=new Invoker();
        //客户要求增加一项需求
        System.out.println("=================客户要求删除一个页面=================");
        Command command=new DeletePageCommand();
        xiao.setCommand(command);
        xiao.action();

    }
}
