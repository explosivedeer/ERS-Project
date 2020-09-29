package com.ers.service;

import java.util.Scanner;

import com.ers.model.Reimbursement;
import com.ers.model.User;

public class ReimbursementDriver {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		ReimbursementService rs = new ReimbursementService();
		System.out.println("ReimbursementService.class");
		System.out.println("findAll()");
		System.out.println("--------------------------");
		System.out.println("TEST RETURN JSON RESULT:");
		System.out.println(rs.findAll());
		System.out.println("--------------------------");
		System.out.println("create(t)");
		Reimbursement reimb = new Reimbursement();
		User user = new User();
		System.out.println("amount:");
		reimb.setAmount(sc.nextInt());
		System.out.println("description:");
		reimb.setDescription(sc.next());
		user.setId(1); //testing id of 1
		System.out.println("You are logged in as: " + user.getId());
		reimb.setAuthor(user.getId());
		reimb.setStatusid(1);
		int status = reimb.getStatusid();
		switch (status) {
		case 1:
			System.out.println("The ticket's status is now: Pending");
			break;
		case 2:
			System.out.println("The ticket's status is now: Denied");
			break;
		case 3:
			System.out.println("The ticket's status is now: Approved");
			break;
		default:
			System.out.println("There was an error retreiving status!");
			break;
		}
		
		System.out.println("Ticket Type: (Enter number) \n"
							+ "1. Lodging \n"
							+ "2. Travel \n"
							+ "3. Food \n"
							+ "4. Other \n");
		reimb.setTypeid(sc.nextInt());
		
		System.out.println("Your Reimbursement Ticket: ");
		System.out.println(rs.create(reimb));

	}

}
