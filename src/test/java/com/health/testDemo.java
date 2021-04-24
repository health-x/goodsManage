package com.health;

import com.health.dao.GoodsMapper;
import com.health.pojo.Goods;
import com.health.pojo.GoodsExample;
import com.health.service.BrandService;
import com.health.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-mybatis.xml")
public class testDemo {

    @Autowired
    GoodsService goodsService;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    BrandService brandService;

    @Test
    public void test1(){
        System.out.println(goodsService.findAll());
    }

    @Test
    public void test2(){
        System.out.println(goodsMapper.queryAll());
    }

    @Test
    public void test3(){
        System.out.println(brandService.findAll());
    }

    @Test
    public void test4(){
        System.out.println(goodsMapper.selectByExample(new GoodsExample()));
    }
}
