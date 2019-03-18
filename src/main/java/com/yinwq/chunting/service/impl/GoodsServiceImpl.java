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

	@Override
	public int insertGoods(Goods goods) {
		goodsDao.insert(goods);
		return goods.getId();
	}

	@Override
	public Goods getGoodsById(Integer goodsId) {
		return goodsDao.selectByPrimaryKey(goodsId);
	}

	@Override
	public PagedData<Goods> selectGoodsList(Goods goods) {
		PagedData<Goods> paged= new PagedData<Goods>();
		paged.setPageNo(goods.getPageNo());
		paged.setPageSize(goods.getPageSize());
		paged.setTotalSize(goodsDao.selectGoodsListCount(goods));
		paged.setResultList(goodsDao.selectGoodsList(goods));
		return paged;
	}

	@Override
	public int updateGoods(Goods goods) {
		int isTure = goodsDao.updateByPrimaryKeySelective(goods);
		if(isTure == 1){
			return goods.getId();
		}
		System.out.println("修改失败！");
		return 0;
	}

	@Override
	public int deleteGoods(Integer goodsId) {
		return goodsDao.deleteByPrimaryKey(goodsId);
	} 
    
  
}  