package com.zk.ssmbuild.service;

import com.zk.ssmbuild.pojo.Book;

import java.util.List;

public interface BookService {

   int  addBook(Book book);
   int  updateBook(Book book);
   Book  queryBook(int id);
   int  deletBook(int id);
   List<Book> books();

}
