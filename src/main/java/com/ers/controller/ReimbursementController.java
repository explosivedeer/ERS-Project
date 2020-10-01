package com.ers.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.model.Reimbursement;
import com.ers.model.User;
import com.ers.service.ReimbursementService;

public class ReimbursementController {
	
	private ReimbursementService rs;
	
	public ReimbursementController() {
		rs = new ReimbursementService();
	}
	
	public String createReimbursement(HttpServletRequest req) {
		System.out.println("Creating a ticket");
		HttpSession sess = req.getSession();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		int typeid = Integer.parseInt(req.getParameter("typeid"));
		switch (typeid) {
		case 1:
			typeid = 1;
			break;
		case 2:
			typeid = 2;
			break;
		case 3:
			typeid = 3;
			break;
		case 4:
			typeid = 4;
			break;
		default:
			System.out.println("invalid type");
			break;
		}
		
		int amount = Integer.parseInt(req.getParameter("amount"));
		String submitted = LocalDate.now().toString();
		String description = req.getParameter("description");
		Reimbursement reimb = new Reimbursement();
		User user = new User();
		reimb.setAuthor(user.getId());
		reimb.setAmount(amount);
		reimb.setDescription(description);
		reimb.setTypeid(typeid);
		reimb.setStatusid(1);
		
		rs.createReimbursement(reimb);
		
		return "/ERS/employee.html";
		
	}
	
	public String findByUsername(HttpServletRequest req, HttpServletResponse res) {
		String json = "";
		try {
			HttpSession session = req.getSession();
			String user = (String) session.getAttribute("user");
			json = rs.findByUsername(user).toString();
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			res.getWriter().write(json);
			System.out.println(json);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	public String seePending(HttpServletRequest req, HttpServletResponse res) {
		String json = "";
		try {
			HttpSession session = req.getSession();
			json = rs.seePending().toString();	
			res.setContentType("application/json");
			res.setCharacterEncoding("UTF-8");
			res.getWriter().write(json);
			System.out.println(json);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	public String updateReimbursementStatus(HttpServletRequest req) {
		System.out.println("Updating Reimbursement Status!");
		HttpSession session = req.getSession();
		int id = Integer.parseInt(req.getParameter("typeid"));
		String resolved = LocalDate.now().toString();
		Reimbursement reimb = new Reimbursement();
		int status = reimb.getStatusid();
		rs.updateReimbursementStatus(id, status);
		return "/html/loginServlet.html";
	}
	
	
	
}
