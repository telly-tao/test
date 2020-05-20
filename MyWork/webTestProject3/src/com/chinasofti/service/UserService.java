package com.chinasofti.service;

import java.util.List;

import com.chinasofti.model.User;

public interface UserService {

	User getUser(String username, String password);

	int reg(User user);

	List<User> RequestList(String username);


}
