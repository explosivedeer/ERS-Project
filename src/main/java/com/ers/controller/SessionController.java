package com.ers.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionController {
	
	public void createSession(HttpServletRequest req) {
		System.out.println("Session created");
		HttpSession session = req.getSession();
		session.setAttribute("user", req.getParameter("username"));
		session.setAttribute("pass", req.getParameter("password"));
	}
	
}
