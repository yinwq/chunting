package com.yinwq.chunting.dao;

import java.util.List;

import com.yinwq.chunting.entity.Goods;


public interface IGoodsDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    
    List<Goods> selectGoodsList(Goods goods);
    
    int selectGoodsListCount(Goods goods);
}