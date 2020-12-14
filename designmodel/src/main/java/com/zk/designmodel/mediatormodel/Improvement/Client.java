package com.zk.designmodel.mediatormodel.Improvement;

public class Client {


    public static void main(String[] args) {
        AbstractMediator abstractMediator=new Mediator();
        //采购人员采购电脑
        System.out.println("===========采购人员采购电脑================");
        Purchase purchase=new Purchase(abstractMediator);
        purchase.buyIBMComputer(100);
        //销售人员销售电脑
        System.out.println("===========销售人员销售电脑================");
        Sale sale=new Sale(abstractMediator);
        sale.sellIBMComputer(1);
        //库房管理人员管理库存
        System.out.println("===========库存管理人员清库电脑================");
        Stock stock=new Stock(abstractMediator);
        stock.clearStock();
    }
}
