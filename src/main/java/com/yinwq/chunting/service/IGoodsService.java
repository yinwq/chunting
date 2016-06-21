package com.yinwq.chunting.service;  

import java.util.List;

import com.yinwq.chunting.entity.Goods;
  
public interface IGoodsService {  
	
	public int insertGoods(Goods goods);
	
	public Goods getGoodsById(Integer goodsId);
	
	public List<Goods> selectGoodsList(Goods goods);
}  