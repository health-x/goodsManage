package com.health.controller;

import com.health.entity.PageResult;
import com.health.entity.Result;
import com.health.pojo.User;
import com.health.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/add")
	public Result add(@RequestBody User user){
		if(userService.findOne(user.getUsername())!=null){
			return new Result(false,"用户已存在！");
		}else{
			try {
				userService.add(user);
				return new Result(true, "注册成功 可以登录啦！");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false, "增加失败");
			}
		}
	}
}