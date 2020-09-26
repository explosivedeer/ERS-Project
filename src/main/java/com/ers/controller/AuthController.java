package com.ers.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.service.AuthService;

public class AuthController {
	
	private AuthService as;
	
	public AuthController() {
		as = new AuthService();
	}
	
	
	public void login(HttpServletRequest req, HttpServletResponse res) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean b = as.login(username, password);
		String result = b? "<h1>You are now logged in!</h1>" : "<h1>You failed to login!</h1>";
		try {
			res.getWriter().println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
