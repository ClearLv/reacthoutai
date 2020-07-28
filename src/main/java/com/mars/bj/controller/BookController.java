package com.mars.bj.controller;

import com.mars.bj.pojo.Book;
import com.mars.bj.pojo.Cate;
import com.mars.bj.result.Result;
import com.mars.bj.service.BookService;
import com.mars.bj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/getAllBook")
    public List<Book> getAllBook(){
        return bookService.findAllBook();
    }

    @GetMapping("/getAllCate")
    public List<Cate> getAllCate(){
        return bookService.findAllCate();
    }

    @PostMapping("/postBookInfo")
    public Result postBook(@RequestBody Book book){
        int i = bookService.addBook(book);
        if(i != 0){
            return new Result(200);
        }else {
            return new Result(500);
        }
    }

    @GetMapping("/getBookById")
    public Book getBookById(@RequestParam("bookId") Integer bookId){
        Book book = bookService.findBookById(bookId);
        return book;
    }


}
