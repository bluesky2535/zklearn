package com.zk.designmodel.commandmodel;

public class Invoker {
    //什么命令
    Command command;
    //客户发出命令
    public void setCommand(Command command){
        this.command=command;
    }
    //执行客户的命令
    public void action(){
        this.command.execute();
    }
}
