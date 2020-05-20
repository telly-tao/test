package com.chinasofti.dao;

import java.util.List;

import com.chinasofti.model.User;

public interface UserDao {

	int reg(User user);

	User login(String username, String password);

	List<User> requestList(String username);

}
