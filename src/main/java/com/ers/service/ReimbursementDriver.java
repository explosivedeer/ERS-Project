package com.ers.service;

public class ReimbursementDriver {

	public static void main(String[] args) {
		
		ReimbursementService rs = new ReimbursementService();
		System.out.println("ReimbursementService.class");
		System.out.println("--------------------------");
		System.out.println("TEST RETURN JSON RESULT:");
		System.out.println(rs.findAll());

	}

}
