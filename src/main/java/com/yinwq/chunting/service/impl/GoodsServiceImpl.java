package com.yinwq.chunting.service.impl;  
  
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yinwq.chunting.dao.IGoodsDao;
import com.yinwq.chunting.entity.Goods;
import com.yinwq.chunting.service.IGoodsService;
import com.yinwq.chunting.util.PagedData;
  
  
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

	public PagedData<Goods> selectGoodsList(Goods goods) {
		// TODO Auto-generated method stub
		PagedData<Goods> paged= new PagedData<Goods>();
		paged.setPageNo(goods.getPageNo());
		paged.setPageSize(goods.getPageSize());
		paged.setResultList(goodsDao.selectGoodsList(goods));
		return paged;
	} 
    
  
}  