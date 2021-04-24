package com.health.service.impl;

import com.health.dao.BrandMapper;
import com.health.pojo.Brand;
import com.health.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.queryAll();
    }
}
