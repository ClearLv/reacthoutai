package com.mars.bj.dao;

import com.mars.bj.pojo.User;
import com.mars.bj.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User getUserByName(String name);
//    int deleteByExample(UserExample example);
//
//    int deleteByPrimaryKey(Integer id);
//
//    int insert(User record);
//
//    int insertSelective(User record);
//
//    List<User> selectByExample(UserExample example);
//
//    User selectByPrimaryKey(Integer id);
//
//    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);
//
//    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
//
//    int updateByPrimaryKeySelective(User record);
//
//    int updateByPrimaryKey(User record);
}