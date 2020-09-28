package com.ers.model;

public class UserRole {

	private int id;
	private int role; /* int instead of varchar */

	public UserRole(int id, int role) {
		super();
		this.id = id;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "{ \"userrole\":{\"id\":" + id + ", \"role\": \"" + role + "\"}}";
	}

}
