package com.zk.designmodel.visitmodel;

public interface IVisitor {

    public void visit(CommonEmployee commonEmployee);
    public void visit(Manager manager);

}
