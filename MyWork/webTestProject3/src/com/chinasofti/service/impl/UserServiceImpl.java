package com.chinasofti.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.chinasofti.dao.UserDao;
import com.chinasofti.dao.impl.UserDaoImpl;
import com.chinasofti.model.User;
import com.chinasofti.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User getUser(String username, String password) {
		UserDao userDao = new UserDaoImpl();
		return userDao.login(username, password);
	}

	@Override
	public int reg(User user) {
		UserDao userDao = new UserDaoImpl();
		return userDao.reg(user);
	}

	@Override
	public List<User> RequestList(String username) {
		List<User> users=new ArrayList<User>();
		UserDao userDao = new UserDaoImpl();
		users=userDao.requestList(username);
		return users;
	}

}
