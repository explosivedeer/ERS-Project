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
				
				//CHECKING DATABASE FOR MATCHING USERNAME AND PASSWORD
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
//			
//			//GET LIST OF REIMBURSEMENT BASED ON USERNAME
//			boolean ticketuser = true;
//			if(ticketuser) {
//				List<Reimbursement> list = new LinkedList<Reimbursement>();
//				try {
//					Connection conn = ConnectionUtil.getInstance().getConnection();
//					String sql = "select * from reimbursement where username = '" + newAccount.getUsername() + "';";
//					PreparedStatement ps = conn.prepareStatement(sql);
//					ResultSet rs = ps.executeQuery();
//					while(rs.next()) {
//						list.add(new Reimbursement(rs.getInt("reimbid"),rs.getString("username"),rs.getString("reimtype")
//								,rs.getString("submitted"),rs.getString("resolved"),rs.getString("description")
//								,rs.getString("status"),rs.getDouble("amount")));
//					}
//					conn.close();
//					rs.close();
//					ps.close();
//				}catch(SQLException e) {
//					e.printStackTrace();
//				}
//				System.out.println(list);
//			}
//			
//			
//			//GET LIST OF ALL REIMBURSEMENT TICKETS
//			boolean listall = false;
//			if(listall) {
//				List<Reimbursement> list = new LinkedList<Reimbursement>();
//				try {
//					Connection conn = ConnectionUtil.getInstance().getConnection();
//					String sql = "select * from reimbursement";
//					PreparedStatement ps = conn.prepareStatement(sql);
//					ResultSet rs = ps.executeQuery();
//					while(rs.next()) {
//						list.add(new Reimbursement(rs.getInt("reimbid"),rs.getString("username"),rs.getString("reimtype")
//								,rs.getString("submitted"),rs.getString("resolved"),rs.getString("description")
//								,rs.getString("status"),rs.getDouble("amount")));
//					}
//					conn.close();
//					rs.close();
//					ps.close();
//				}catch(SQLException e) {
//					e.printStackTrace();
//				}
//				System.out.println(list);
//			}
//			
//			
//			//CREATING A NEW REIMBURSEMENT TICKET
//			boolean reimb = false;
//			if(reimb) {
//				System.out.println("Enter Reimbursement Type (LODGING, TRAVEL, FOOD, OR OTHER)");
//				newTicket.setReimtype(userInput.nextLine());				
//				
//				System.out.println("Enter Description");
//				newTicket.setDescription(userInput.nextLine());
//				
//				System.out.println("Enter Date (Month/Day/Year)");
//				newTicket.setSubmitted(userInput.nextLine());
//				
//				System.out.println("Enter Amount");
//				newTicket.setAmount(userInput.nextDouble());
//				
//				try {
//					Connection conn = ConnectionUtil.getInstance().getConnection();
//					String sql = "Insert into reimbursement values (DEFAULT,?,?,?,?,NULL,?,'pending')";
//					PreparedStatement ps = conn.prepareStatement(sql);
//					ps.setString(1, newAccount.getUsername());
//					ps.setString(2, newTicket.getReimtype());
//					ps.setDouble(3, newTicket.getAmount());
//					ps.setString(4, newTicket.getSubmitted());
//					ps.setString(5, newTicket.getDescription());
//					ps.executeUpdate();
//					conn.close();
//					ps.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			
//			//CHECKING A TICKET AS AN MANAGER
//			if(newAccount.isManagestatus()) {
//				List<Reimbursement> list = new LinkedList<Reimbursement>();
//				try {
//					Connection conn = ConnectionUtil.getInstance().getConnection();
//					String sql = "select * from reimbursement where status = 'pending';";
//					PreparedStatement ps = conn.prepareStatement(sql);
//					ResultSet rs = ps.executeQuery();
//					while(rs.next()) {
//						list.add(new Reimbursement(rs.getInt("reimbid"),rs.getString("username"),rs.getString("reimtype")
//								,rs.getString("submitted"),rs.getString("resolved"),rs.getString("description")
//								,rs.getString("status"),rs.getDouble("amount")));
//					}
//					conn.close();
//					rs.close();
//					ps.close();
//				}catch(SQLException e) {
//					e.printStackTrace();
//				}
//				System.out.println("These are the pending Tickets");
//				System.out.println(list);
//			}
//			
//			//APPROVING TICKETS BASED ON REIMBURSEMENT ID AS MANAGER
//			if(newAccount.isManagestatus()) {
//				int id = 0;
//				
//				System.out.println("Enter Date (Month/Day/Year)");
//				newTicket.setResolved(userInput.nextLine());
//				System.out.println("Enter Reimbursement ID that you want to approve");
//				id = userInput.nextInt();
//				
//				
//				try {
//					Connection conn = ConnectionUtil.getInstance().getConnection();
//					String sql = "update reimbursement set status = 'approved' where reimbid = "+ id + ";";
//					PreparedStatement ps = conn.prepareStatement(sql);
//					ps.executeUpdate();
//					sql = "update reimbursement set resolved = '"+ newTicket.getResolved() +"' where reimbid = "+ id + ";";
//					ps = conn.prepareStatement(sql);
//					ps.executeUpdate();
//					conn.close();
//					ps.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			
//			//DENYING TICKETS BASED ON REIMBURSEMENT ID AS MANAGER
//			if(newAccount.isManagestatus()) {
//				int id = 0;
//				
//				System.out.println("Enter Date (Month/Day/Year)");
//				newTicket.setResolved(userInput.nextLine());
//				System.out.println("Enter Reimbursement ID that you want to deny");
//				id = userInput.nextInt();
//				
//				
//				try {uuuuuuuu
//					Connection conn = ConnectionUtil.getInstance().getConnection();
//					String sql = "update reimbursement set status = 'denied' where reimbid = "+ id + ";";
//					PreparedStatement ps = conn.prepareStatement(sql);
//					ps.executeUpdate();
//					sql = "update reimbursement set resolved = '"+ newTicket.getResolved() +"' where reimbid = "+ id + ";";
//					ps = conn.prepareStatement(sql);
//					ps.executeUpdate();
//					conn.close();
//					ps.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
	
	}
}
