package com.project.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.model.User;
import com.project.service.UserService;

public class UserController {
	
	private UserService us; 
	
	public UserController() {
		us = new UserService();
	}
	 
	public String login(HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean authenticated = us.login(username, password);
		if (authenticated) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			return"html/welcome.html";
		} else {
			return "home.app";
		}
	}
	
	public void sendData(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession ();
		User u = new User(0, session.getAttribute("username").toString (), session.getAttribute("password").toString());
		try {
			res.getWriter().println(u.toString());
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
