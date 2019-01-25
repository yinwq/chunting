package com.yinwq.chunting.service.impl;  
  
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yinwq.chunting.dao.IGoodsDao;
import com.yinwq.chunting.entity.Goods;
import com.yinwq.chunting.service.IGoodsService;
import com.yinwq.chunting.common.util.PagedData;
  
  
@Service("goodsService")  
public class GoodsServiceImpl implements IGoodsService {  
    @Resource  
    private IGoodsDao goodsDao;

	public int insertGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsDao.insert(goods);
		return goods.getId();
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
		paged.setTotalSize(goodsDao.selectGoodsListCount(goods));
		paged.setResultList(goodsDao.selectGoodsList(goods));
		return paged;
	}

	public int updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		int isTure = goodsDao.updateByPrimaryKeySelective(goods);
		if(isTure == 1){
			return goods.getId();
		}
		System.out.println("修改失败！");
		return 0;
	}

	public int deleteGoods(Integer goodsId) {
		// TODO Auto-generated method stub
		return goodsDao.deleteByPrimaryKey(goodsId);
	} 
    
  
}  