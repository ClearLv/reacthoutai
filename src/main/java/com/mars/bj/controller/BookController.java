package com.mars.bj.controller;

import com.mars.bj.pojo.Book;
import com.mars.bj.pojo.Cate;
import com.mars.bj.result.Result;
import com.mars.bj.service.BookService;
import com.mars.bj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("api/getAllCate")
    public List<Cate> getAllCate(){
        return bookService.findAllCate();
    }

    @PostMapping("api/postBookInfo")
    public Result postBook(@RequestBody Book book){
        int i = bookService.addBook(book);
        if(i != 0){
            return new Result(200);
        }else {
            return new Result(500);
        }
    }

}
