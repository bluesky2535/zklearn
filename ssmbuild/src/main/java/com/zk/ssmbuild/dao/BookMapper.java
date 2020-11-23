package com.zk.ssmbuild.dao;

import com.zk.ssmbuild.pojo.Book;

import java.util.List;

public interface BookMapper {
    //添加书籍
    int  addBook(Book book);
    //更新书籍
    int  updateBook(Book book);
    //查询书籍
    Book  queryBook(int id);
    //删除书籍
    int  deleteBook(int id);
    //查询所有书籍
    List<Book> books();

}
