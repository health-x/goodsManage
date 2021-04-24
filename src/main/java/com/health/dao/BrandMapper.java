package com.health.dao;

import com.health.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(Brand record);

    int insertSelective(Brand record);

    Brand selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    List<Brand> queryAll();
}