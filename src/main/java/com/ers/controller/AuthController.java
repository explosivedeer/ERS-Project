package com.ers.controller;


import javax.servlet.http.HttpServletRequest;

import com.ers.service.AuthService;

public class AuthController {
	
	private AuthService as;
	
	public AuthController() {
		as = new AuthService();
	}
	
	public String login(HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean b = as.verifyUser(username, password);
		
		if(b) {
			new SessionController().createSession(req);
			if(as.getRole(username) != -1) {
				return "/loginServlet.html";
			}
			else {
				return "/html/employee.html";
			}
		} else {
			return "/html/404-page.html";	
			}
	}
}
