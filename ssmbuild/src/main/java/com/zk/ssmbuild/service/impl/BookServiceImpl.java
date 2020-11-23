package com.zk.ssmbuild.service.impl;

import com.zk.ssmbuild.dao.BookMapper;
import com.zk.ssmbuild.pojo.Book;
import com.zk.ssmbuild.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private  BookMapper bookMapper;
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int addBook(Book book) {
        int i = bookMapper.addBook(book);
        return i;
    }

    @Override
    public int updateBook(Book book) {
        int i = bookMapper.updateBook(book);
        return i;
    }

    @Override
    public Book queryBook(int id) {
        Book book = bookMapper.queryBook(id);
        return book;
    }

    @Override
    public int deletBook(int id) {

        int i = bookMapper.deleteBook(id);
        return i;
    }

    @Override
    public List<Book> books() {
        List<Book> books = bookMapper.books();
        return books;
    }
}
