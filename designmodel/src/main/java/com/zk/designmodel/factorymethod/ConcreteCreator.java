package com.zk.designmodel.factorymethod;

public class ConcreteCreator<T>  implements  Creator<T>{

    @Override
    public <T extends  Product> T create(Class<T> c)  {
        Product product =null;
        try {
             product =(Product) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)product;
    }
}
