package com.ers.service;

import com.ers.model.User;
import com.ers.repo.UserDao;

public class AuthService {
	
	private UserDao ud;
	
	public AuthService() {
		ud = new UserDao();
	}
	
	public boolean verifyUser(String username, String password) {
		User u = ud.verifyUser(username, password);
		return password.equals(u.getPassword());
	}
	
	public int getRole(String username) {
		return ud.getRole(username);
	}
	
}
