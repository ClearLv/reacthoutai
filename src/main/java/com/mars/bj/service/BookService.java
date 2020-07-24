package com.mars.bj.service;

import com.mars.bj.pojo.Book;

import java.util.List;

public interface BookService {
    List<Book> findAllBook();
    Book findBookById(Integer id);
    Book findBookByName(String name);
}
