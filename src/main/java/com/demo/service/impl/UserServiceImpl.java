package com.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.demo.dao.UserDao;
import com.demo.pojo.User;
import com.demo.service.UserService;

@Component("UserService")
public class UserServiceImpl implements UserService {

	@Resource
	UserDao userDao;
	
	@Override
	public User getUserByUserId(String userId) {
		return userDao.getUserByUserId(userId);
	}

}
