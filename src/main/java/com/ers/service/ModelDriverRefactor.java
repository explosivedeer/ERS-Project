package com.ers.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.ers.model.Reimbursement;
import com.ers.model.User;
import com.ers.config.ConnectionUtil;

public class ModelDriverRefactor {
	
	public static void main(String[] args) {
		Scanner userInput = new Scanner (System.in);
		User newAccount = new User();
		Reimbursement newTicket = new Reimbursement();
		

			boolean employ = true;
			while (employ) {
				System.out.println("Enter Username");
				newAccount.setUsername(userInput.nextLine());
				
				System.out.println("Enter Password");
				newAccount.setPassword(userInput.nextLine());
				
				//login testing
				try {
					Connection conn = ConnectionUtil.getInstance().getConnection();
					String sql = "select * from ers_users";
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						if (newAccount.getUsername().equalsIgnoreCase(rs.getString("ers_username")) 
								&& newAccount.getPassword().equalsIgnoreCase(rs.getString("ers_password")) )
						{
							newAccount.setFirstname(rs.getString("user_first_name"));
							newAccount.setLastname(rs.getString("user_last_name"));
							newAccount.setEmail(rs.getString("user_email"));
							newAccount.setId(rs.getInt("ers_users_id"));
							newAccount.setRole(rs.getInt("user_role_id"));
							employ = false;
							break;
						};	
					}
					conn.close();
					ps.close();
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				if (employ) {
					System.out.println("Wrong username or password");
				}else {
					break;
				}
			}
			System.out.println(newAccount);
	}
}
