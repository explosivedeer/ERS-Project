package com.ers.model;

public class User {
	
	//fields we get from user
	private String username;
	private String password;
	
	//fields we get from database
	private int id;
	private int role;
	private String firstname;
	private String lastname;
	private String email;
	
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getRole() {
		return role;
	}
	
	public void setRole(int role) {
		this.role = role;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	

	@Override
	public String toString() {
		return "{ \"user\":{\"id\":"+id+", \"username\": \""+username+"\", \"role\":\""+role+"\"}}";
	}
	//This is formatting for JSON
	
	/* Example JSON
	 * 
	 * {	
	 * 		"user":{
	 * 			"id":0,
	 * 			"username":"tom",
	 * 			"password":"pass",
	 * 			"role":"roll"
	 * 		}
	 * }
	 * 
	 */
	
}
