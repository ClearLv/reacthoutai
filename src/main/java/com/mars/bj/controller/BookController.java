package com.mars.bj.controller;

import com.mars.bj.pojo.Book;
import com.mars.bj.pojo.Cate;
import com.mars.bj.result.Result;
import com.mars.bj.service.BookService;
import com.mars.bj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    @PostMapping("/uploadBookCover")
    public String uploadPic(MultipartFile file){
        String folder = "F:/workspace/img";
        File imageFolder = new File(folder);
        File f = new File(imageFolder, System.currentTimeMillis()+file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();
        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8080/file/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

}
