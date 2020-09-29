package com.ers.model;

public class Reimbursement {

	private int id;
	private int amount;
	private String submitted;
	private String resolved;
	private String description;
	// TODO: field for BLOB "REIMB_RECEIPT"
	private int resolver;

	// pass to database
	private int author;
	private String receipt;
	private int statusid;
	private int typeid;
	
	
	
	public Reimbursement(int amount, String submitted, String description, int author) {
		super();
		this.amount = amount;
		this.submitted = submitted;
		this.description = description;
		this.author = author;
	}

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}
	
	public String getReceipt() {
		return receipt;
	}
	
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public int getStatusid() {
		return statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	@Override
	public String toString() {
		return "{ \"reimbursement\":{\"id\":"+id+", \"amount\": \""+amount+"\", \"submitted\": \""+submitted+"\", \"description\": \""+description+"\", \"author\": \""+author+"\"}}";
	}
	
	// ie from user "{ \"user\":{\"id\":"+id+", \"username\": \""+username+"\", \"password\":\""+password+"\"}}";
	//This is formatting for JSON
	
		/* Example JSON
		 * 
		 * {	
		 * 		"reimbursement":{
		 * 			"id":1,
		 * 			"amount":0,
		 * 			"submitted":"tom",
		 * 			"description":"pass",
		 * 			"author":"author"
		 * 		}
		 * }
		 * 
		 */

	
}
