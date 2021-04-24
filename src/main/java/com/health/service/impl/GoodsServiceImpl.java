package com.health.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.health.dao.GoodsMapper;
import com.health.entity.PageResult;
import com.health.pojo.Goods;
import com.health.pojo.GoodsExample;
import com.health.pojo.GoodsExample.Criteria;
import com.health.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Goods> findAll() {
		return goodsMapper.queryAll();
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Goods> page=   (Page<Goods>) goodsMapper.queryAll();
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Goods goods) {
		goodsMapper.insert(goods);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Goods goods){
		goodsMapper.updateByPrimaryKey(goods);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Goods findOne(Integer id){
		return goodsMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			goodsMapper.deleteByPrimaryKey(id);
		}		
	}


	@Override
	public PageResult findPage(Goods goods, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);

		GoodsExample example=new GoodsExample();
		Criteria criteria = example.createCriteria();

		if(goods!=null){
			if(goods.getName()!=null && goods.getName().length()>0){
				criteria.andNameLike("%"+goods.getName()+"%");
			}			if(goods.getBrand()!=null && goods.getBrand().length()>0){
				criteria.andBrandLike("%"+goods.getBrand()+"%");
			}			if(goods.getDes()!=null && goods.getDes().length()>0){
				criteria.andDesLike("%"+goods.getDes()+"%");
			}
		}
		Page<Goods> page= (Page<Goods>)goodsMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
