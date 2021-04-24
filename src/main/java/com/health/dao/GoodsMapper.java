package com.health.dao;

import com.health.pojo.Goods;
import com.health.pojo.GoodsExample;

import java.util.List;

public interface GoodsMapper {

    List<Goods> queryAll();

    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> selectByExample(GoodsExample example);

}