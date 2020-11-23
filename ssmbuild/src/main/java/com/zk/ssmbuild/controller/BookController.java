package com.zk.ssmbuild.controller;

import com.zk.ssmbuild.pojo.Book;
import com.zk.ssmbuild.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {


    @Autowired
    @Qualifier("bookServiceImpl")
    BookService bookService;


    @RequestMapping("/showAllBooks")
    public String showAllBooks(Model model){
        List<Book> books = bookService.books();
        model.addAttribute("list",books);
        return "books";
    }
}
