package com.yinwq.chunting.service;  

import com.yinwq.chunting.entity.Admin;
  
public interface IAdminService {  
	public int insert(Admin admin);
	
	public Admin getAdminById(int adminId);

	public Admin loginAdmin(Admin admin);
}  