package com.mars.bj.controller;

import com.mars.bj.pojo.Book;
import com.mars.bj.service.BookService;
import com.mars.bj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("api/getAllBook")
    public List<Book> getAllBook(){
        return bookService.findAllBook();
    }

}
