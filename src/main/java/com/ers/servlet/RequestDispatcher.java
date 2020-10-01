package com.ers.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.controller.AuthController;
import com.ers.controller.ReimbursementController;
import com.ers.controller.UserController;

public class RequestDispatcher {

	public static void dataRetriever(HttpServletRequest req, HttpServletResponse resp) {
		switch (req.getRequestURI()) {
		case "/ERS/currentReimbursement.json":
			new ReimbursementController().findByUsername(req, resp);
			break;
		case "/ERS/pendingReimbursement.json":
			new ReimbursementController().seePending(req, resp);
		}
	}

	public static String retrievePage(HttpServletRequest req) {
		System.out.println(req.getRequestURI());
		
		switch (req.getRequestURI()) {
		case "/ERS/html/login.app":
			return new AuthController().login(req);
		case "/ERS/html/reimbursement.app":
			return new ReimbursementController().createReimbursement(req);
		case "/ERS/html/updateStatus.app":
			return new ReimbursementController().updateReimbursementStatus(req);
		case "/ERS/anything.app":
			return "/webapp/html/404-page.html";
		default:
			return "/webapp/html/404-page.html";
		}
	}
}
