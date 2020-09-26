package com.project.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.controller.UserController;

public class RequestDispatcher {
	
	public static String routes (HttpServletRequest req) {
		switch(req.getRequestURI()) {
		case"/ExpenseReimbursement/home.app":
			return "html/login.html";
		case "/ExpenseReimbursment/login.app":
			return new UserController().login(req);
		default:
			return"html/login.html";
		}
	}
	
	public static void data(HttpServletRequest req, HttpServletResponse res) {
		switch(req.getRequestURI()) {
		case "/ExpenseReimbursement/user.data":
			new UserController().sendData(req, res);
		}
	}

}
 