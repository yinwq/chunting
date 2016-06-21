package com.yinwq.chunting.service.impl;  
  
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yinwq.chunting.dao.IAdminDao;
import com.yinwq.chunting.entity.Admin;
import com.yinwq.chunting.service.IAdminService;
  
  
@Service("adminService")  
public class AdminServiceImpl implements IAdminService {  
    @Resource  
    private IAdminDao adminDao;

	public int insert(Admin admin) {
		return adminDao.insert(admin);
	}

	public Admin getAdminById(int adminId) {
		return adminDao.selectByPrimaryKey(adminId);
	}

	public Admin loginAdmin(Admin admin) {
		return adminDao.loginAdmin(admin);
	}
  
}  