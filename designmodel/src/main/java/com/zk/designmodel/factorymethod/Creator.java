package com.zk.designmodel.factorymethod;

public interface Creator<T> {
      public <T extends  Product> T create(Class<T> c) throws ClassNotFoundException;
}
