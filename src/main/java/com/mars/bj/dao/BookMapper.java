package com.mars.bj.dao;

import com.mars.bj.pojo.Book;

import java.util.List;

public interface BookMapper {
    List<Book> selectAllBook();
    Book selectBookById(Integer id);
    Book selectBookByName(String name);
}
