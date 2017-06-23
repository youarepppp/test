package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.entity.User;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;

	public int addUser(User user) {
		return userDao.addUser(user);
	}
	
	public User testUser(User user) {
		user.setId(11111);
		user.setName("aaa");
		return user;
	}

	public User findOneUser(int id) {
		return userDao.findOneUser(id);
	}

	public String register(User user) {
		User user2 = userDao.findUserByName(user.getName());
		if (user2 == null) {
			userDao.addUser(user);
			return "成功";
		} else {
			return "失败";
		}
	}
}
