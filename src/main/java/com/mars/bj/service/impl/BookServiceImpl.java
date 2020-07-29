package com.mars.bj.service.impl;

import com.mars.bj.dao.BookMapper;
import com.mars.bj.dao.UserMapper;
import com.mars.bj.pojo.Book;
import com.mars.bj.pojo.Cate;
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
    public Book findBookById(Integer bookId) {
        return bookMapper.selectBookById(bookId);
    }

    @Override
    public Book findBookByName(String name) {
        return bookMapper.selectBookByName(name);
    }

    @Override
    public List<Cate> findAllCate() {
        return bookMapper.selectAllCate();
    }

    @Override
    public int addBook(Book book) {
        return bookMapper.insertBook(book);
    }

    @Override
    public int editBookInfo(Book book) {
        return bookMapper.updateBookInfo(book);
    }
}
