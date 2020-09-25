package com.ers.service;

import java.util.List;

import com.ers.model.User;
import com.ers.repo.UserDao;

public class UserService {
	
	private UserDao ud;
	
	public UserService() {
		ud = new UserDao();
	}
	
	public List<User> findAll() {
		return ud.findAll();
	}
}
