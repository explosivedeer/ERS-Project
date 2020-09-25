package com.project.service;

import com.project.dao.UserDao;
import com.project.model.User;

public class UserService {
	
	private UserDao ud;
	
	public UserService() {
		ud = new UserDao();
	}
	
	public boolean login(String username, String password) {
		User u = ud.findByUsername(username);
		if (u == null) {
			return false;
		}
		return password.equals(u.getPassword());
	}

}
