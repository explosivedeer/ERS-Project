package com.ers.model;

public class ReimbursementType {

	private int id;
	private String type;

	public ReimbursementType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "{ \"reimbursementtype\":{\"id\":"+id+", \"type\": \""+type+"\"}}";
	}
	
	
	
}
