package com.mars.bj.pojo;

import lombok.Data;

@Data
public class Book {
    private Integer id;
    private String cover;
    private String title;
    private String author;
    private String date;
    private String press;
    private String abs;
    private String cate;
    private Integer cid;
}
