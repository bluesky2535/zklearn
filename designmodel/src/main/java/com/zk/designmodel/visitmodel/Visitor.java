package com.zk.designmodel.visitmodel;

public class Visitor implements IVisitor{
    @Override
    public void visit(CommonEmployee commonEmployee) {
        System.out.println(this.getCommonEmployeeInfo(commonEmployee));
    }

    @Override
    public void visit(Manager manager) {
        System.out.println(this.getManagerInfo(manager));
    }

    //组装基本信息
    private String getBasicInfo(Employee employee){
        String info="姓名："+employee.getName()+"\t"+"性别"+employee.getSex()+"薪水"+employee.getSalary();
        return info;
    }


    //组装部门经理的信息
    private String getManagerInfo(Manager manager){
        String info=this.getBasicInfo(manager)+"业绩"+manager.getPerformance();
        return info;
    }

    //组装普通员工信息
    private String getCommonEmployeeInfo(CommonEmployee commonEmployee){
        String info=this.getBasicInfo(commonEmployee)+"工作"+commonEmployee.getJob();
        return info;
    }

}
