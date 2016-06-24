package com.yinwq.chunting.dao;

import java.util.List;

import com.yinwq.chunting.entity.Area;


public interface IAreaDao {
    int deleteByPrimaryKey(Integer areaId);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer areaId);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);

	List<Area> selectAreaList(Area area);
}