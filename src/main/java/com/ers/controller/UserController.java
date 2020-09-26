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
	
	//TODO: do something for if there is an IO Exception
	public void findAllUsers(HttpServletRequest req, HttpServletResponse res) {
		try {
			res.getWriter().print(us.findAll());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
