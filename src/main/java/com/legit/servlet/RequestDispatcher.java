package com.legit.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.legit.controller.AuthController;
import com.legit.controller.UserController;

public class RequestDispatcher {

	public static void dataRetriever(HttpServletRequest req, HttpServletResponse resp) {
		switch (req.getRequestURI()) {
		case "/BootWebService/user.json":
			new UserController().findAllUsers(req, resp);
			break;
		case "/BootWebService/login.json":
			new AuthController().login(req, resp);
		}
	}

	public static String retrievePage(HttpServletRequest req) {
		System.out.println(req.getRequestURI());
		
		switch (req.getRequestURI()) {
		case "/BootWebService/home.app":
			System.out.println("You hit me");
			return "html/index.html";
		case "/BootWebService/session.app":
			return "html/session.html";
		default:
			System.out.println("defaulted???");
			System.out.println(req);
			return "html/404-page.html";
		}
		// return "html/index.html";
	}
}
