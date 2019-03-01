package com.demo.service;

import com.demo.pojo.User;

public interface UserService {
	
	/**
	 * 根据用户id获取用户名
	 * @param userId
	 * @return
	 */
	public User getUserByUserId(String userId);
}
