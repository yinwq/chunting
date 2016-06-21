package com.yinwq.chunting.service.impl;  
  
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yinwq.chunting.dao.IUserDao;
import com.yinwq.chunting.entity.User;
import com.yinwq.chunting.service.IUserService;
  
  
@Service("userService")  
public class UserServiceImpl implements IUserService {  
    @Resource  
    private IUserDao userDao; 
    
    public User getUserById(int userId) {  
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(userId);  
    }  
  
}  