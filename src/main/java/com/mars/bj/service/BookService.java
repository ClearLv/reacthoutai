package com.mars.bj.service;

import com.mars.bj.pojo.Book;
import com.mars.bj.pojo.Cate;

import java.util.List;

public interface BookService {
    List<Book> findAllBook();
    Book findBookById(Integer bookId);
    Book findBookByName(String name);
    List<Cate> findAllCate();
    int addBook(Book book);
    int editBookInfo(Book book);
}
