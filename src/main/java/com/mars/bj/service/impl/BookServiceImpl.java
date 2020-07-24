package com.mars.bj.service.impl;

import com.mars.bj.dao.BookMapper;
import com.mars.bj.dao.UserMapper;
import com.mars.bj.pojo.Book;
import com.mars.bj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> findAllBook() {
        return bookMapper.selectAllBook();
    }

    @Override
    public Book findBookById(Integer id) {
        return bookMapper.selectBookById(id);
    }

    @Override
    public Book findBookByName(String name) {
        return bookMapper.selectBookByName(name);
    }
}