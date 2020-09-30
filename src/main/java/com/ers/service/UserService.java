package com.ers.service;

import com.ers.model.User;
import com.ers.repo.UserDao;

public class UserService {
	
	private UserDao ud;
	
	public UserService() {
		ud = new UserDao();
	}
	
	public boolean verifyUser(User t) {
		return ud.verifyUser(t);
	}
	
	public int getRole(User t) {
		return ud.getRole(t);
	}
}
