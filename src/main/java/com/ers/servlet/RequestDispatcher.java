package com.ers.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.controller.AuthController;
import com.ers.controller.UserController;

public class RequestDispatcher {

	public static void dataRetriever(HttpServletRequest req, HttpServletResponse resp) {
		switch (req.getRequestURI()) {
		case "/ERSystem/user.json":
			new UserController().findAllUsers(req, resp);
			break;
		case "/ERS/login.json":
			new AuthController().login(req, resp);
		}
	}

	public static String retrievePage(HttpServletRequest req) {
		System.out.println(req.getRequestURI());
		
		switch (req.getRequestURI()) {
		case "/ERS/home.app":
			System.out.println("You hit me");
			return "html/login.html";
		case "/ERS/session.app":
			return "html/session.html";
		default:
			System.out.println("defaulted???");
			System.out.println(req);
			return "html/404-page.html";
		}
		// return "html/index.html";
	}
}
