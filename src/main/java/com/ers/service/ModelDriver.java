package com.ers.service;

import java.util.Scanner;

import com.ers.model.Reimbursement;
import com.ers.model.User;
import com.ers.repo.UserDao;

public class ModelDriver {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		User user = new User();
		AuthService as = new AuthService();
		UserDao ud = new UserDao();
		Reimbursement reimb = new Reimbursement();
		ReimbursementService rs = new ReimbursementService();
		
		System.out.println("AuthService.class");
		System.out.println("verifyUser(username, password)");
		System.out.println("--------------------------");
		System.out.println("Username: ");
		user.setUsername(sc.next());
		System.out.println("Password: ");
		user.setPassword(sc.next());
		System.out.println();
		System.out.println("Logged in?");
		System.out.println(as.verifyUser(user.getUsername(), user.getPassword()));
		
		System.out.println("Our current user: ");
		System.out.println(ud.verifyUser(user.getUsername(), user.getPassword()));
		
//		System.out.println("UserService.class");
//		System.out.println("verifyUser(User t)");
//		System.out.println("--------------------------");
//		System.out.println("Username: ");
//		user.setUsername(sc.next());
//		System.out.println("Password: ");
//		user.setPassword(sc.next());
//		System.out.println();
//		System.out.println(us.verifyUser(user));
//		System.out.println("Role: " + us.getRole(user));
//		System.out.println("findAll():" + us.findAll());
//		System.out.println("--------------------------");
//		System.out.println("ReimbursementService.class");
//		System.out.println("findAll()");
//		System.out.println("--------------------------");
//		System.out.println("TEST RETURN JSON RESULT:");
//		user.setId(1);
//		System.out.println(rs.findAll());
//		System.out.println("--------------------------");
//		System.out.println("create(t)");
//		
//		System.out.println("amount:");
//		reimb.setAmount(sc.nextInt());
//		System.out.println("description:");
//		reimb.setDescription(sc.next());
//		user.setId(1); //testing id of 1
//		System.out.println("You are logged in as: " + user.getId());
//		reimb.setAuthor(user.getId());
//		reimb.setStatusid(1);
//		int status = reimb.getStatusid();
//		switch (status) {
//		case 1:
//			System.out.println("The ticket's status is now: Pending");
//			break;
//		case 2:
//			System.out.println("The ticket's status is now: Denied");
//			break;
//		case 3:
//			System.out.println("The ticket's status is now: Approved");
//			break;
//		default:
//			System.out.println("There was an error retreiving status!");
//			break;
//		}
//		
//		System.out.println("Ticket Type: (Enter number) \n"
//							+ "1. Lodging \n"
//							+ "2. Travel \n"
//							+ "3. Food \n"
//							+ "4. Other \n");
//		reimb.setTypeid(sc.nextInt());
//		
//		System.out.println("Your Reimbursement Ticket: ");
//		System.out.println(rs.create(reimb));

	}

}
