package com.chinasofti.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.chinasofti.dao.UserDao;
import com.chinasofti.dao.impl.UserDaoImpl;
import com.chinasofti.model.User;
import com.chinasofti.service.UserService;
import com.chinasofti.util.TurnPageUtil;

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
	public List<User> RequestList() {
		UserDao user = new UserDaoImpl();
		List<User> source =new ArrayList<User>();
		//获取结果
		source= user.RequestList();
		
		System.out.println("home:"+user);
		if (source.get(0)!=null) {
			return source;
		} else {
			return null;
		}

	}

	@Override
	public List<User> SerarchList(String username) {
		List<User> users=new ArrayList<User>();
		UserDao userDao = new UserDaoImpl();
		users=userDao.SerarchList(username);
		return users;
	}

	@Override
	public int countpage(String username ) {
		int sumCount=1;
		UserDao userDao = new UserDaoImpl();
		int count=userDao.countpage(username);
		if(count%TurnPageUtil.row==0) {
			sumCount=count/TurnPageUtil.row;
		}else {
			sumCount=count/TurnPageUtil.row+1;
		}
		return sumCount;
	}

}
