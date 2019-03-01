package com.demo.dao;

import org.apache.ibatis.annotations.Param;

import com.demo.pojo.User;

public interface UserDao {
	/**
	 * 根据userId获取用户信息
	 * @return
	 */
	public User getUserByUserId(@Param("userId") String userId);
}
