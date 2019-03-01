package com.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.pojo.ResultBean;
import com.demo.pojo.User;
import com.demo.service.UserService;

@Controller
public class TestAopController {
	@Resource
	UserService userService;
	
	@RequestMapping("/getUsername")
	@ResponseBody
	public ResultBean<User> getUsername(User user){
		return new ResultBean<>(userService.getUserByUserId(user.getUserId()));
	}
}
