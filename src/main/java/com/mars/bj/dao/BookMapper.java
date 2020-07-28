package com.mars.bj.dao;

import com.mars.bj.pojo.Book;
import com.mars.bj.pojo.Cate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    List<Book> selectAllBook();
    Book selectBookById(@Param("bookId") Integer bookId);
    Book selectBookByName(String name);
    List<Cate> selectAllCate();
    int insertBook(Book book);
}
