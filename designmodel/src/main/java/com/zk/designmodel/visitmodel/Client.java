package com.zk.designmodel.visitmodel;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        for (Employee employee : mockEmployee()) {
            employee.accept(new Visitor());
        }
    }



    public static List<Employee> mockEmployee(){
        List<Employee> empList=new ArrayList<>();

        CommonEmployee zhangsan=new CommonEmployee();
        zhangsan.setJob("搬砖");
        zhangsan.setName("张三");
        zhangsan.setSalary(1800);
        zhangsan.setSex(Employee.MALE);
        empList.add(zhangsan);

        Manager manager=new Manager();
        manager.setName("王五");
        manager.setSalary(2500);
        manager.setSex(Employee.FEMALE);
        manager.setPerformance("刚刚的");

        empList.add(manager);
        return empList;

    }

}
