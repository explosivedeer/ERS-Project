package com.ers.service;

import java.util.List;

import com.ers.model.Reimbursement;
import com.ers.repo.ReimbursementDao;

public class ReimbursementService {

	private ReimbursementDao rd;
	private Reimbursement reimb;
	
	public ReimbursementService() {
		rd = new ReimbursementDao();
		reimb = new Reimbursement();
	}
	
	public List<Reimbursement> findAll() {
		return rd.findAll();
	}
	
	public int createReimbursement(Reimbursement t) {
		return rd.createReimbursement(t);
	}
	
	public List<Reimbursement> findByUsername(String username){
		return rd.findByUsername(username);
	}
	
	public List<Reimbursement> seePending(){
		return rd.seePending();
	}
	
	public void updateReimbursementStatus(int id, int status) {
		rd.updateReimbursementStatus(id, status);
	}
	
}
