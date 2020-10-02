package com.ers.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.service.UserService;

public class UserController {
	
	private UserService us;

	public UserController() {
		us = new UserService();
	}
	
	public String login(HttpServletRequest req) {
		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		boolean authenticated = us.login(username, password);
		if (authenticated) {
			HttpSession session = req.getSession();
			session.setAttribute("user", username);
			session.setAttribute("pass", password);
			return "html/welcome.html";
		} else {
			return "home.app";
		}
	}
	
	//TODO: do something for if there is an IO Exception
	public void findAllUsers(HttpServletRequest req, HttpServletResponse res) {
		try {
			res.getWriter().print(us.findAll());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
