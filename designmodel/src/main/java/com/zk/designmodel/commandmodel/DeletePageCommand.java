package com.zk.designmodel.commandmodel;

public class DeletePageCommand extends Command{
    @Override
    public void execute() {
        //找到需求组
        super.pg.find();
        //增加一份需求
        super.pg.add();
        //给出计划
        super.pg.plan();
    }
}
