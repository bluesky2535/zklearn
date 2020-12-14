package com.zk.designmodel.mediatormodel.Improvement;

public class Mediator extends  AbstractMediator{


    @Override
    public void execute(String str, Object... objects) {
        if(str.equals("purchase.buy")){
            this.buyComputer((Integer)objects[0]);
        }else if(str.equals("sale.sell")){
            this.sellComputer((Integer)objects[0]);
        }else if(str.equals("sale.offSell")){
            this.offSell();
        }else if(str.equals("stock.clear")){
            this.clearStock();
        }
    }

    //采购电脑
    private void buyComputer(int number){
        int saleStatus=super.sale.getSaleStatus();
        //销售情况良好
        if(saleStatus>80){
            System.out.println("采购IBM电脑"+number+"台");
            super.stock.increase(number);
        }else{
            //销售情况不好 折半采购
            int buyNumber=number/2;
            System.out.println("采购IBM电脑："+buyNumber+"台");
        }
    }
    //销售电脑
    private  void sellComputer(int number){
        //库存数量不够销售
        if(super.stock.getStockNumber()<number){
            super.purchase.buyIBMComputer(number);

        }
        super.stock.decrease(number);

    }

    //折价销售电脑
    private  void offSell(){
        System.out.println("折价销售IBM电脑"+stock.getStockNumber());
    }

    //清仓处理
    private void clearStock(){
        //要求清仓销售
        super.sale.offSale();
        //要求采购人员不要采购
        super.purchase.refuseBuyIBM();
    }



















}
