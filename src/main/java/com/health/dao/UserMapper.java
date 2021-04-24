package com.health.dao;

import com.health.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> queryAll();

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByUsername(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}