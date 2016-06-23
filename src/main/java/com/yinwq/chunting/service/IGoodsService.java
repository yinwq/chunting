package com.yinwq.chunting.service;  

import com.yinwq.chunting.entity.Goods;
import com.yinwq.chunting.util.PagedData;
  
public interface IGoodsService {  
	
	public int insertGoods(Goods goods);
	
	public Goods getGoodsById(Integer goodsId);
	
	public PagedData<Goods> selectGoodsList(Goods goods);
	
	public int updateGoods(Goods goods);
	
	public int deleteGoods(Integer id);
}  