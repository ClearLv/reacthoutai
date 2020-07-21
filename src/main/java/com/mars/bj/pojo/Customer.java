package com.mars.bj.pojo;

import lombok.Data;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

@Data
public class Customer {
    private String usernum;
    private String userpwd;
}
