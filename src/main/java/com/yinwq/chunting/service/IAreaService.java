package com.yinwq.chunting.service;  

import java.util.List;

import com.yinwq.chunting.entity.Area;
  
public interface IAreaService {  
	
	public Area getAreaById(Integer areaId);
	
	public List<Area> selectAreaList(Area area);
	
}  