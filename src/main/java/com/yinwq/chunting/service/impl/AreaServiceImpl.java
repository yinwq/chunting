package com.yinwq.chunting.service.impl;  
  
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yinwq.chunting.dao.IAreaDao;
import com.yinwq.chunting.entity.Area;
import com.yinwq.chunting.service.IAreaService;
  
  
@Service("areaService")  
public class AreaServiceImpl implements IAreaService {  
    @Resource  
    private IAreaDao areaDao;

	public Area getAreaById(Integer areaId) {
		// TODO Auto-generated method stub
		return areaDao.selectByPrimaryKey(areaId);
	}

	public List<Area> selectAreaList(Area area) {
		// TODO Auto-generated method stub
		return areaDao.selectAreaList(area);
	}

}  