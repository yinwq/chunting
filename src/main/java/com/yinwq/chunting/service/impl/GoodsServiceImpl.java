package com.yinwq.chunting.service.impl;  
  
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yinwq.chunting.dao.IGoodsDao;
import com.yinwq.chunting.entity.Goods;
import com.yinwq.chunting.service.IGoodsService;
  
  
@Service("goodsService")  
public class GoodsServiceImpl implements IGoodsService {  
    @Resource  
    private IGoodsDao goodsDao;

	public int insertGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.insert(goods);
	}

	public Goods getGoodsById(Integer goodsId) {
		// TODO Auto-generated method stub
		return goodsDao.selectByPrimaryKey(goodsId);
	}

	public List<Goods> selectGoodsList(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.selectGoodsList(goods);
	} 
    
  
}  