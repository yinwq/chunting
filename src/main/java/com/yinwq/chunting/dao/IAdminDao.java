package com.yinwq.chunting.dao;

import com.yinwq.chunting.entity.Admin;


public interface IAdminDao {
    int deleteByPrimaryKey(Integer adminid);

    int insert(Admin admin);

    int insertSelective(Admin admin);

    Admin selectByPrimaryKey(Integer adminid);

    int updateByPrimaryKeySelective(Admin admin);

    int updateByPrimaryKey(Admin admin);
    
    Admin loginAdmin(Admin admin);
}